package com.unimag.encuestapp.domain.model.shared.exceptions;

/**
 * Survey name should not be null or empty exception
 */
public class SurveyNameShouldNotBeNullOrEmptyException extends EncuestappException {
    private static final long serialVersionUID = -6379677444347164045L;

    /**
     * Constructor
     */
    public SurveyNameShouldNotBeNullOrEmptyException() {
        super("EA-SN-001", SurveyNameShouldNotBeNullOrEmptyException.class.getSimpleName(),
                "The name survey should not be null or empty", "The name survey is required");
    }
}
