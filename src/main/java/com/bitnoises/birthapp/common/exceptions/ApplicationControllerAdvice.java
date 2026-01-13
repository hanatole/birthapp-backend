package com.bitnoises.birthapp.common.exceptions;

import com.bitnoises.birthapp.common.entity.ErrorResponseEntity;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@ControllerAdvice
public class ApplicationControllerAdvice {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public @ResponseBody ErrorResponseEntity handleNotFound(EntityNotFoundException exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponseEntity(null, exception.getMessage());
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public @ResponseBody ErrorResponseEntity handleConstraintViolation(
            DataIntegrityViolationException exception) {
        log.error(exception.getMessage(), exception);
        return new ErrorResponseEntity(null, exception.getMessage());
    }
}
