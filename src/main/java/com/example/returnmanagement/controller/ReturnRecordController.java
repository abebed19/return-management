package com.example.returnmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.returnmanagement.dto.CreateReturnRecordRequest;
import com.example.returnmanagement.dto.ReturnRecordResponse;
import com.example.returnmanagement.enums.ReturnRecordStatus;
import com.example.returnmanagement.service.ReturnRecordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/returns")
public class ReturnRecordController {
	
	private final ReturnRecordService returnRecordService;
	
	public  ReturnRecordController(ReturnRecordService returnRecordService) {
		this.returnRecordService = returnRecordService;
	}
	
	@PostMapping
	public ResponseEntity<ReturnRecordResponse> createReturnRecord(@Valid @RequestBody CreateReturnRecordRequest returnRecordRequest){
		
		ReturnRecordResponse returnRecordResponse = returnRecordService.createReturnRecord(returnRecordRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnRecordResponse);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ReturnRecordResponse> getReturnRecordById(@PathVariable Long id){
		
		return ResponseEntity.ok(returnRecordService.findReturnRecordById(id));
		
	}
	@GetMapping
	public ResponseEntity<List<ReturnRecordResponse>> getAllReturnRecords(
			 @RequestParam(required = false) ReturnRecordStatus status
			){
		
		return ResponseEntity.ok(this.returnRecordService.findReturnRecords(status));
	
	}


}
