package com.unimag.encuestapp.domain.model.shared.exceptions;

/**
 * Encuestapp date time format exception
 */
public class EncuestappDateTimeFormatException extends EncuestappException {
    private static final long serialVersionUID = -8984254364454239644L;


    /**
     * Constructor
     *
     * @param detail The detail error
     */
    public EncuestappDateTimeFormatException(String detail) {
        super("EA-DT-001", EncuestappDateTimeFormatException.class.getSimpleName(), "An error has occurred processing a date or time.", detail);
    }

}
