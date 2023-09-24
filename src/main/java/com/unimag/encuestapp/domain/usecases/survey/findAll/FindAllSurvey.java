package com.unimag.encuestapp.domain.usecases.survey.findAll;

import com.unimag.encuestapp.domain.model.survey.Survey;
import com.unimag.encuestapp.domain.model.survey.findAll.FindAllSurveyComand;
import com.unimag.encuestapp.domain.model.survey.findAll.IFindAllSurvey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import reactor.core.publisher.Flux;

/**
 * Find all survey use case
 */
public class FindAllSurvey implements IFindAllSurvey {
    private final ISurveyPersistGateway surveyPersistGateway;

    /**
     * Constructor
     *
     * @param surveyPersistGateway The survey persist gateway
     */
    public FindAllSurvey(ISurveyPersistGateway surveyPersistGateway) {
        this.surveyPersistGateway = surveyPersistGateway;
    }

    @Override
    public Flux<Survey> findAll(FindAllSurveyComand findAllSurveyComand) {
        return surveyPersistGateway.findAll();
    }
}
