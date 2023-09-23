package com.unimag.encuestapp.domain.model.survey.create;

import com.unimag.encuestapp.domain.model.survey.Survey;
import reactor.core.publisher.Mono;

/**
 * Create Survey use case
 */
public interface ICreateSurvey {

    /**
     * Create Survey method
     *
     * @param createSurveyCommand The Create Survey command
     * @return Stream Survey (Mono)
     */
    Mono<Survey> create(CreateSurveyCommand createSurveyCommand);
}
