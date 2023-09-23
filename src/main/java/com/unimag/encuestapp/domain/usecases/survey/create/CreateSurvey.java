package com.unimag.encuestapp.domain.usecases.survey.create;

import com.unimag.encuestapp.domain.model.shared.exceptions.OptionsShouldNotBeNullOrEmptyException;
import com.unimag.encuestapp.domain.model.survey.DateTimeSurvey;
import com.unimag.encuestapp.domain.model.survey.Option;
import com.unimag.encuestapp.domain.model.survey.Survey;
import com.unimag.encuestapp.domain.model.survey.SurveyName;
import com.unimag.encuestapp.domain.model.survey.create.CreateSurveyCommand;
import com.unimag.encuestapp.domain.model.survey.create.ICreateSurvey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * Create Survey use case
 */
public class CreateSurvey implements ICreateSurvey {
    private final ISurveyPersistGateway surveyPersistGateway;


    /**
     * Constructor
     *
     * @param surveyPersistGateway The Survey persist gateway
     */
    public CreateSurvey(ISurveyPersistGateway surveyPersistGateway) {
        this.surveyPersistGateway = surveyPersistGateway;
    }

    @Override
    public Mono<Survey> create(CreateSurveyCommand createSurveyCommand) {

        var surveyName = new SurveyName(createSurveyCommand.getName());
        var createAt = new DateTimeSurvey(new Date());
        var expirationAt = new DateTimeSurvey(createSurveyCommand.getExpirationAt());

        if (createSurveyCommand.getOptions() == null || createSurveyCommand.getOptions().isEmpty())
            throw new OptionsShouldNotBeNullOrEmptyException();


        var survey = Survey.builder()
                .name(surveyName)
                .multiple(createSurveyCommand.isMultiple())
                .createAt(createAt)
                .expirationAt(expirationAt)
                .options(createSurveyCommand.getOptions()
                        .stream()
                        .map(option -> Option.builder()
                                .name(option)
                                .build())
                        .toList())
                .build();
        return surveyPersistGateway.persist(survey);
    }
}
