package com.AutoEmailMate.eg.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(UserNameAlreadyExists.class)
        public ResponseEntity<String> handleUserNameAlreadyExists(UserNameAlreadyExists ex) {
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(EmailAlreadyExists.class)
        public ResponseEntity<String> handleEmailAlreadyExists(EmailAlreadyExists ex) {
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        @ExceptionHandler(IncorrectPassWord.class)
    public ResponseEntity<String> handleIncorrectPassWord(IncorrectPassWord ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }}

