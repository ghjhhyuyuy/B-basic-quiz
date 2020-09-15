package com.thoughtworks.basic.handler;

import com.thoughtworks.basic.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidParameterException;

/**
 * Created by wzw on 2020/9/14.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<UserException> handle(UserException exception) {
        HttpStatus state = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(state).body(exception);
    }

    @ExceptionHandler(InvalidParameterException.class)
    public ResponseEntity<InvalidParameterException> handle(InvalidParameterException exception) {
        HttpStatus state = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(state).body(exception);
    }
}
