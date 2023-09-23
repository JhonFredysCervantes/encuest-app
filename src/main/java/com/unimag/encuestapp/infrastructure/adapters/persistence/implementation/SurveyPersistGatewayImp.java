package com.unimag.encuestapp.infrastructure.adapters.persistence.implementation;

import com.unimag.encuestapp.domain.model.survey.Survey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import com.unimag.encuestapp.infrastructure.adapters.persistence.entities.SurveyEntity;
import com.unimag.encuestapp.infrastructure.adapters.persistence.repositories.ISurveyRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Survay persist gateway implementation
 */
@Service
public class SurveyPersistGatewayImp implements ISurveyPersistGateway {
    private final ISurveyRepository surveyRepository;

    public SurveyPersistGatewayImp(ISurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public Mono<Survey> persist(Survey survey) {
        return surveyRepository
                .save(SurveyEntity.toEntity(survey))
                .map(SurveyEntity::toModel);
    }
}
