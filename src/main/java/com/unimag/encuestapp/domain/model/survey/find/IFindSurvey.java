package com.unimag.encuestapp.domain.model.survey.find;

import com.unimag.encuestapp.domain.model.survey.Survey;
import reactor.core.publisher.Mono;

/**
 * Find survey interface
 */
public interface IFindSurvey {

    /**
     * Find survey by id
     *
     * @param findSurveyCommand The find survey command
     * @return The survey
     */
    Mono<Survey> findById(FindSurveyCommand findSurveyCommand);
}
