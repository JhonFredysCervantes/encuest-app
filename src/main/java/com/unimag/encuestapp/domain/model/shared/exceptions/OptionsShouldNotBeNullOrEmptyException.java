package com.unimag.encuestapp.domain.model.shared.exceptions;

/**
 * Options should not be null or empty exception
 */
public class OptionsShouldNotBeNullOrEmptyException extends EncuestappException {
    private static final long serialVersionUID = -7026064083913441263L;

    /**
     * Constructor
     */
    public OptionsShouldNotBeNullOrEmptyException() {
        super("EA-OPT-001", OptionsShouldNotBeNullOrEmptyException.class.getSimpleName(),
                "The Survey options should not be null or empty", "The Survey options are required");
    }
}
