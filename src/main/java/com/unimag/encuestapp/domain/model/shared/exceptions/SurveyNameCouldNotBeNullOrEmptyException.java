package com.unimag.encuestapp.domain.model.shared.exceptions;

/**
 * Survey name could not be null or empty exception
 */
public class SurveyNameCouldNotBeNullOrEmptyException extends EncuestappException {
    private static final long serialVersionUID = -6379677444347164045L;

    /**
     * Constructor
     */
    public SurveyNameCouldNotBeNullOrEmptyException() {
        super("EA-SN-001", SurveyNameCouldNotBeNullOrEmptyException.class.getSimpleName(),
                "The name survey could not be null or empty", "The name survey is required");
    }
}
