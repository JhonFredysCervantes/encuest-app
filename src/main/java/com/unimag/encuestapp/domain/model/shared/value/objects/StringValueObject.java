package com.unimag.encuestapp.domain.model.shared.value.objects;

import java.io.Serializable;

/**
 * String value object
 */
public abstract class StringValueObject implements Serializable {
    private static final long serialVersionUID = -1441462138290543295L;
    private final String value;

    /**
     * Constructor
     *
     * @param value The value
     */
    protected StringValueObject(String value) {
        this.value = value;
    }

    /**
     * Get value
     *
     * @return The value
     */
    public String value() {
        return value;
    }
}
