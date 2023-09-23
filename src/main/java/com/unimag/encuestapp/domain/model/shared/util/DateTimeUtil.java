package com.unimag.encuestapp.domain.model.shared.util;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static java.util.Objects.isNull;
import static lombok.AccessLevel.PRIVATE;

/**
 * Date time util
 */
@NoArgsConstructor(access = PRIVATE)
public class DateTimeUtil {

    /**
     * Convert date to local date time method
     *
     * @param dateToConvert The date to convert
     * @return The local date time
     */
    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {

        if (isNull(dateToConvert)) {
            return null;
        }
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Convert local date time to date method
     *
     * @param dateToConvert The local date time to convert
     * @return The date
     */
    public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {

        if (isNull(dateToConvert)) {
            return null;
        }
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}
