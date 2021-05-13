package com.example.demo;

import com.example.demo.exception.RoomException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseExceptionHandler {
    @RequiredArgsConstructor
    @Getter
    public final static class ErrorModel {
        private final String errorMessage;
    }

    @ExceptionHandler(RoomException.class)
    public ResponseEntity<ErrorModel> handleBadToken(RoomException exception) {
        return new ResponseEntity<>(new ErrorModel(exception.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }
}
