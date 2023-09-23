package com.unimag.encuestapp.infrastructure.entry_points.rest.error;

import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappDateTimeFormatException;
import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappError;
import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappException;
import com.unimag.encuestapp.domain.model.shared.exceptions.SurveyNameCouldNotBeNullOrEmptyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.unimag.encuestapp.domain.model.shared.constants.ErrorConstans.DEFAULT_ERROR_CODE;
import static com.unimag.encuestapp.domain.model.shared.constants.ErrorConstans.DEFAULT_ERROR_MESSAGE;
import static com.unimag.encuestapp.domain.model.shared.constants.ErrorConstans.EXCEPTION;

/**
 * Ecuestapp handler error
 */
@ControllerAdvice
@Slf4j
public class EcuestappHandlerError {

    /**
     * Default handler
     *
     * @param e The exception
     * @return Encuestapp error
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<EncuestappError> defaultHandler(Exception e) {
        log.error("HANDLING ERROR: {}", e.toString());

        var error = EncuestappError.builder()
                .code(DEFAULT_ERROR_CODE)
                .exception(EXCEPTION)
                .message(DEFAULT_ERROR_MESSAGE)
                .detail(e.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Bad request handler
     *
     * @param e The exception
     * @return Encuestapp error
     */
    @ExceptionHandler({EncuestappDateTimeFormatException.class, SurveyNameCouldNotBeNullOrEmptyException.class})
    public ResponseEntity<EncuestappError> badRequestHandler(EncuestappException e) {
        log.error("HANDLING ERROR: {}", e.toString());
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }
}
