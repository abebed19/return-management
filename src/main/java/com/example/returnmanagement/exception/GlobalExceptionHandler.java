package com.example.returnmanagement.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
	public ResponseEntity<List<MethodArgumentErrorDto>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		List<MethodArgumentErrorDto> errors = new ArrayList<>();
		ex.getBindingResult().getFieldErrors()
		       .forEach(error->{
		    	   errors.add(new MethodArgumentErrorDto(error.getField(),error.getDefaultMessage()));
		       });
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		
	}

}
