package com.university.test.exception.handler;

import com.university.test.exception.ErrorResponse;
import com.university.test.exception.ResourceAlreadyExistsException;
import com.university.test.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.rmi.ServerException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(NOT_FOUND.toString(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
//        ErrorResponse errorResponse = new ErrorResponse(INTERNAL_SERVER_ERROR.toString(), ex.getMessage());
//        return new ResponseEntity<>(errorResponse, INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceAlreadyExistsException ex) {
        ErrorResponse errorResponse = new ErrorResponse(CONFLICT.toString(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, CONFLICT);
    }

}
