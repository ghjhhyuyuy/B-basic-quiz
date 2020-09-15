package com.thoughtworks.basic.handler;

import com.thoughtworks.basic.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.thoughtworks.basic.result.Error;
import java.security.InvalidParameterException;
import java.util.Date;

/**
 * Created by wzw on 2020/9/14.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Error> handle(UserException exception) {
        HttpStatus state = HttpStatus.NOT_FOUND;
        Error error = new Error();
        error.setStatus(state.value());
        error.setError(state.name());
        error.setTimestamp(new Date().toString());
        error.setMessage(exception.getMeg());
        return ResponseEntity.status(state).body(error);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<Error> handle(InvalidParameterException exception) {
        HttpStatus state = HttpStatus.BAD_REQUEST;
        Error error = new Error();
        error.setStatus(state.value());
        error.setError(state.name());
        error.setTimestamp(new Date().toString());
        error.setMessage(exception.getMessage());
        return ResponseEntity.status(state).body(error);
    }
}
