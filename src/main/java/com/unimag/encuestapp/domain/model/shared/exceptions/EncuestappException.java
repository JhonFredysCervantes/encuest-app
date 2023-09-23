package com.unimag.encuestapp.domain.model.shared.exceptions;

import lombok.Getter;

/**
 * Encuestapp exception
 */
@Getter
public class EncuestappException extends RuntimeException {
    private static final long serialVersionUID = -8442289467803940697L;
    private final EncuestappError error;


    /**
     * Constructor
     *
     * @param detail The detail error
     */
    public EncuestappException(String code, String exception, String message, String detail) {
        super(detail);
        this.error = new EncuestappError(code, exception, message, detail);
    }
}
