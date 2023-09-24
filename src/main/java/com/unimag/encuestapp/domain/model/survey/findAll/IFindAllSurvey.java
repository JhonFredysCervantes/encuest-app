package com.unimag.encuestapp.domain.model.survey.findAll;

import com.unimag.encuestapp.domain.model.survey.Survey;
import reactor.core.publisher.Flux;

/**
 * Find all survey interface
 */
public interface IFindAllSurvey {

    /**
     * Find all survey method
     *
     * @param findAllSurveyComand The find all survey command
     * @return The survey flux
     */
    Flux<Survey> findAll(FindAllSurveyComand findAllSurveyComand);
}
