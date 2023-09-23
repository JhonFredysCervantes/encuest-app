package com.unimag.encuestapp.domain.model.shared.value.objects;

import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappDateTimeFormatException;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.unimag.encuestapp.domain.model.shared.constants.ExpressionsConstants.DATE_TIME_FORMAT;

/**
 * Date time value object
 */
public class DateTimeValueObject implements Serializable {
    private static final long serialVersionUID = -6936002836084481078L;
    private final Date dateTime;


    /**
     * Constructor
     *
     * @param dateTime The date time
     */
    public DateTimeValueObject(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * Constructor
     *
     * @param dateTime The date time
     *                 Format: yyyy-MM-dd'T'HH:mm:ss.SSSZ
     *                 Example: 2021-10-10T00:00:00.000-0500
     *                 This method converts the string to a date with the format yyyy-MM-dd'T'HH:mm:ss.SSSZ
     */
    public DateTimeValueObject(String dateTime) {

        if (dateTime == null || dateTime.isEmpty()) {
            this.dateTime = null;
            return;
        }

        try {
            this.dateTime = new SimpleDateFormat(DATE_TIME_FORMAT).parse(dateTime);
        } catch (ParseException e) {
            throw new EncuestappDateTimeFormatException(e.getMessage());
        }

    }

    /**
     * Value
     *
     * @return The date time
     */
    public Date value() {
        return dateTime;
    }
}
