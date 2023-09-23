package com.unimag.encuestapp.domain.model.survey;

import com.unimag.encuestapp.domain.model.shared.value.objects.DateTimeValueObject;

import java.util.Date;

/**
 * Survey domain
 */
public class DateTimeSurvey extends DateTimeValueObject {
    private static final long serialVersionUID = -7238111467870924474L;

    public DateTimeSurvey(Date dateTime) {
        super(dateTime);
    }

    public DateTimeSurvey(String dateTime) {
        super(dateTime);
    }
}
