package com.example.returnmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.returnmanagement.service.ReturnRecordService;

@RestController
@RequestMapping("/api/returns")
public class ReturnRecordController {
	
	private ReturnRecordService returnRecordService;
	
	public  ReturnRecordController(ReturnRecordService returnRecordService) {
		this.returnRecordService = returnRecordService;
	}
	
	
	
	

}
