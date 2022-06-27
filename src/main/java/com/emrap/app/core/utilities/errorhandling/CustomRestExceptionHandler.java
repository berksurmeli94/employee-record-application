package com.emrap.app.core.utilities.errorhandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.emrap.app.core.utilities.exceptions.NotFoundException;
import com.emrap.app.core.utilities.exceptions.ValidationException;

@RestControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ValidationException.class })
    public ResponseEntity<Object> handleValidationEXception(ValidationException ex, WebRequest request) {

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
        // If you want to throw apiError directly, uncomment this
        return new ResponseEntity<Object>(apiError, new HttpHeaders(),
                apiError.getStatus());
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex.getMessage());
        // If you want to throw apiError directly, uncomment this
        return new ResponseEntity<Object>(apiError, new HttpHeaders(),
                apiError.getStatus());
    }
}
