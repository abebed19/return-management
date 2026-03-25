package com.example.returnmanagement.service;

import org.springframework.stereotype.Service;

import com.example.returnmanagement.repository.ReturnRecordRepository;

@Service
public class ReturnRecordService {
	
	private ReturnRecordRepository returnRecordRepository;
	
	public ReturnRecordService(ReturnRecordRepository returnRecordRepository) {
		this.returnRecordRepository = returnRecordRepository;
	}

}
