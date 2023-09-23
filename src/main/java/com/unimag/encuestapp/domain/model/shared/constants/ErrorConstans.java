package com.unimag.encuestapp.domain.model.shared.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Error constants
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorConstans {

    public static final String DEFAULT_ERROR_CODE = "DEFAULT-500";
    public static final String EXCEPTION = "Exception";
    public static final String DEFAULT_ERROR_MESSAGE = "We are sorry, an unexpected error has occurred, you are invited to try again or contact the owner of the service.";
}
