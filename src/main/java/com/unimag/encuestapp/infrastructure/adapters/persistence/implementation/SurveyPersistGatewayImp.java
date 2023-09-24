package com.unimag.encuestapp.infrastructure.adapters.persistence.implementation;

import com.unimag.encuestapp.domain.model.survey.Survey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import com.unimag.encuestapp.infrastructure.adapters.persistence.entities.OptionEntity;
import com.unimag.encuestapp.infrastructure.adapters.persistence.entities.SurveyEntity;
import com.unimag.encuestapp.infrastructure.adapters.persistence.repositories.IOptionSurveyRepository;
import com.unimag.encuestapp.infrastructure.adapters.persistence.repositories.ISurveyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Survay persist gateway implementation
 */
@Service
public class SurveyPersistGatewayImp implements ISurveyPersistGateway {
    private final ISurveyRepository surveyRepository;
    private final IOptionSurveyRepository optionSurveyRepository;

    /**
     * Constructor
     *
     * @param surveyRepository       The survey repository
     * @param optionSurveyRepository The option survey repository
     */
    public SurveyPersistGatewayImp(ISurveyRepository surveyRepository, IOptionSurveyRepository optionSurveyRepository) {
        this.surveyRepository = surveyRepository;
        this.optionSurveyRepository = optionSurveyRepository;
    }

    @Override
    public Mono<Survey> persist(Survey survey) {

        var surveySaved = surveyRepository.save(SurveyEntity.toEntity(survey));

        var options = surveySaved.map(surveyEntity -> survey.getOptions().stream()
                        .map(option -> OptionEntity.builder()
                                .name(option.getName())
                                .surveyId(surveyEntity.getId())
                                .build())
                        .toList())
                .flatMapMany(Flux::fromIterable);

        var optionsSaved = optionSurveyRepository.saveAll(options);

        return surveySaved.zipWith(optionsSaved.collectList(), SurveyEntity::toModel);

    }

    @Override
    public Mono<Survey> findById(Long id) {

        return surveyRepository.findById(id)
                .map(surveyEntity -> optionSurveyRepository.findAllBySurveyId(surveyEntity.getId())
                        .collectList()
                        .map(optionEntities -> SurveyEntity.toModel(surveyEntity, optionEntities)))
                .flatMap(Mono::from);
    }

    @Override
    public Flux<Survey> findAll() {
        return surveyRepository.findAll()
                .map(surveyEntity -> optionSurveyRepository.findAllBySurveyId(surveyEntity.getId())
                        .collectList()
                        .map(optionEntities -> SurveyEntity.toModel(surveyEntity, optionEntities)))
                .flatMap(Mono::from);
    }
}
