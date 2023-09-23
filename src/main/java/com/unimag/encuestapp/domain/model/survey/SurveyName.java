package com.unimag.encuestapp.domain.model.survey;

import com.unimag.encuestapp.domain.model.shared.exceptions.SurveyNameShouldNotBeNullOrEmptyException;
import com.unimag.encuestapp.domain.model.shared.value.objects.StringValueObject;

/**
 * Survey name value object
 */
public class SurveyName extends StringValueObject {
    private static final long serialVersionUID = -774087669088517671L;

    /**
     * String value object
     *
     * @param value The value
     */
    public SurveyName(String value) {
        super(value);

        if (value == null || value.trim().isEmpty()) {
            throw new SurveyNameShouldNotBeNullOrEmptyException();
        }
    }
}
