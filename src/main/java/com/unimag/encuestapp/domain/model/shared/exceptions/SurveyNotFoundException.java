package com.unimag.encuestapp.domain.model.shared.exceptions;

/**
 * Survey not found exception
 */
public class SurveyNotFoundException extends EncuestappException {
    private static final long serialVersionUID = -7745221665590893219L;

    /**
     * Constructor
     */
    public SurveyNotFoundException(Long idSurvey) {
        super("EA-SV-001", SurveyNotFoundException.class.getSimpleName(), String.format("Survey with id %s not found", idSurvey), "Survey not found");
    }
}
