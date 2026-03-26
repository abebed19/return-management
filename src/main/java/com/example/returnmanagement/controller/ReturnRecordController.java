package com.example.returnmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.returnmanagement.dto.CreateReturnRecordRequest;
import com.example.returnmanagement.dto.ReturnRecordResponse;
import com.example.returnmanagement.service.ReturnRecordService;

@RestController
@RequestMapping("/api/returns")
public class ReturnRecordController {
	
	private ReturnRecordService returnRecordService;
	
	public  ReturnRecordController(ReturnRecordService returnRecordService) {
		this.returnRecordService = returnRecordService;
	}
	
	@PostMapping
	public ResponseEntity<ReturnRecordResponse> createReturnRecord(@RequestBody CreateReturnRecordRequest returnRecordRequest){
		
		ReturnRecordResponse returnRecordResponse = returnRecordService.createReturnRecord(returnRecordRequest);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnRecordResponse);
		
	}


}
