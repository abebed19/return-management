package com.example.returnmanagement.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.returnmanagement.dto.ErrorResponseDto;
import com.example.returnmanagement.dto.MethodArgumentErrorDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponseDto> handleNullPointerException(RuntimeException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(ex.getMessage(),HttpStatus.BAD_REQUEST.value()));	
	}
	
	@ExceptionHandler(ReturnRecordNotFound.class)
	public ResponseEntity<ErrorResponseDto> handlReturnRecordNotFoundException(ReturnRecordNotFound ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(ex.getMessage(),HttpStatus.NOT_FOUND.value()));
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
		       .forEach(error->{
		    	   errors.put(error.getField(), error.getDefaultMessage());
		       });
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
		
	}
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
		Map<String,String>  error = new HashMap<>();
		String fieldName = ex.getName();
		Object invalidValue  = ex.getValue();
		Class<?> requiredType = ex.getRequiredType();
		if(requiredType != null && requiredType.isEnum()) {
			Object[] enumContrants = requiredType.getEnumConstants();
		
		String allowedValues = Arrays.stream(enumContrants)
				              .map(Object::toString)
				              .collect(Collectors.joining(", "));
				
		  error.put(fieldName,
	                "Invalid value '" + invalidValue + "'. Allowed values: " + allowedValues);
	    } else {
	        error.put(fieldName,
	                "Invalid value '" + invalidValue + "'");
	    }
 		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
		
	}

}
