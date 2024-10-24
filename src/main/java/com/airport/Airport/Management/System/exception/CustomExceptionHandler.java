package com.airport.Airport.Management.System.exception;

import com.airport.Airport.Management.System.dto.ApiResponse;
import com.airport.Airport.Management.System.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> methodArgumentNotValidException(
            MethodArgumentNotValidException e
    ) {
        List<ErrorDto> errors = new ArrayList<>();

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String message = fieldError.getDefaultMessage();
            String rejectionValue = String.valueOf(fieldError.getRejectedValue());
            errors.add(new ErrorDto(fieldName,
                    String.format("%s, Rejection value %s", message, rejectionValue))
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.<Void>builder()
                        .code(-2)
                        .message("Validation failed!")
                        .errorDtoList(errors)
                        .build());
    }

    @ExceptionHandler(value = ContentNotFound.class)
    public ResponseEntity<ApiResponse<Void>> contentNotFoundException(
            ContentNotFound e
    ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.<Void>builder()
                        .code(-1)
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(value = DatabaseException.class)
    public ResponseEntity<ApiResponse<Void>> databaseException(
            DatabaseException e
    ){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.<Void>builder()
                        .code(-3)
                        .message(e.getMessage())
                        .build());
    }


}
