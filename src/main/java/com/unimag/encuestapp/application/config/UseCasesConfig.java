package com.unimag.encuestapp.application.config;

import com.unimag.encuestapp.domain.model.survey.create.ICreateSurvey;
import com.unimag.encuestapp.domain.model.survey.find.IFindSurvey;
import com.unimag.encuestapp.domain.model.survey.findAll.IFindAllSurvey;
import com.unimag.encuestapp.domain.model.survey.gateway.ISurveyPersistGateway;
import com.unimag.encuestapp.domain.usecases.survey.create.CreateSurvey;
import com.unimag.encuestapp.domain.usecases.survey.find.FindSurvey;
import com.unimag.encuestapp.domain.usecases.survey.findAll.FindAllSurvey;
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

    /**
     * Find Survey use case
     *
     * @param surveyPersistGateway The Survey persist gateway
     * @return The find survey use case
     */
    @Bean
    public IFindSurvey findSurvey(ISurveyPersistGateway surveyPersistGateway) {
        return new FindSurvey(surveyPersistGateway);
    }

    /**
     * Find all Survey use case
     *
     * @param surveyPersistGateway The Survey persist gateway
     * @return The find all survey use case
     */
    @Bean
    public IFindAllSurvey findAllSurvey(ISurveyPersistGateway surveyPersistGateway) {
        return new FindAllSurvey(surveyPersistGateway);
    }
}
