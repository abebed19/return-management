package com.example.returnmanagement.exception;

@SuppressWarnings("serial")
public class ReturnRecordNotFound extends RuntimeException{
	
	public ReturnRecordNotFound(String message) {
		super(message);
	}
}
