package com.unimag.encuestapp.domain.model.survey.gateway;

import com.unimag.encuestapp.domain.model.survey.Survey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Survey persist gateway interface
 */
public interface ISurveyPersistGateway {

    /**
     * Persist Survey method
     *
     * @param survey The Survey instance
     * @return Stream Survey (Mono)
     */
    Mono<Survey> persist(Survey survey);

    /**
     * Find Survey by id method
     *
     * @param id The Survey id
     * @return Stream Survey (Mono)
     */
    Mono<Survey> findById(Long id);

    /**
     * Find all Survey method
     *
     * @return Stream Survey (Flux)
     */
    Flux<Survey> findAll();
}
