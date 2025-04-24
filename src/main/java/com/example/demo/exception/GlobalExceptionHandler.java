package com.example.demo.exception;


import com.example.demo.exception.exceptions.BadRequestException;
import com.example.demo.exception.exceptions.ResourceNotFoundException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<Map<String,String>> handleNotFound(ResourceNotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Map.of("error", ex.getMessage()));
//    }
//
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<Map<String,String>> handleBadRequest(BadRequestException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(Map.of("error", ex.getMessage()));
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String,String>> handleValidation(MethodArgumentNotValidException ex) {
//        Map<String,String> errors = new HashMap<>();
//        ex.getBindingResult().getFieldErrors()
//                .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
//        return ResponseEntity.badRequest().body(errors);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Map<String,String>> handleOther(Exception ex) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(Map.of("error", "An unexpected error occurred"));
//    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex, WebRequest req) {
        // log full stack-trace!
        System.out.println(ex.getMessage());

        Map<String, String> body = new HashMap<>();
        body.put("error", ex.getMessage() != null ? ex.getMessage() : "Unknown error");
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
