package com.unimag.encuestapp.application.config;

import com.unimag.encuestapp.domain.model.survey.create.ICreateSurvey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import com.unimag.encuestapp.domain.usecases.survey.create.CreateSurvey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Use cases config
 */
@Configuration
public class UseCasesConfig {

    /**
     * Create Survey use case
     *
     * @param surveyPersistGateway The Survey persist gateway
     * @return The create survey use case
     */
    @Bean
    public ICreateSurvey createSurvey(ISurveyPersistGateway surveyPersistGateway) {
        return new CreateSurvey(surveyPersistGateway);
    }
}
