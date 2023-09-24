package com.unimag.encuestapp.domain.usecases.survey.find;

import com.unimag.encuestapp.domain.model.shared.exceptions.SurveyNotFoundException;
import com.unimag.encuestapp.domain.model.survey.Survey;
import com.unimag.encuestapp.domain.model.survey.find.FindSurveyCommand;
import com.unimag.encuestapp.domain.model.survey.find.IFindSurvey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import reactor.core.publisher.Mono;

/**
 * Find survey use case
 */
public class FindSurvey implements IFindSurvey {
    private final ISurveyPersistGateway surveyPersistGateway;

    /**
     * Constructor
     *
     * @param surveyPersistGateway The survey persist gateway
     */
    public FindSurvey(ISurveyPersistGateway surveyPersistGateway) {
        this.surveyPersistGateway = surveyPersistGateway;
    }

    @Override
    public Mono<Survey> findById(FindSurveyCommand findSurveyCommand) {
        return surveyPersistGateway.findById(findSurveyCommand.getId())
                .switchIfEmpty(Mono.error(new SurveyNotFoundException(findSurveyCommand.getId())));
    }
}
