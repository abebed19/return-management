package com.example.returnmanagement.service;

import org.springframework.stereotype.Service;

import com.example.returnmanagement.dto.CreateReturnRecordRequest;
import com.example.returnmanagement.model.ReturnRecord;
import com.example.returnmanagement.repository.ReturnRecordRepository;

@Service
public class ReturnRecordService {
	
	private ReturnRecordRepository returnRecordRepository;
	
	public ReturnRecordService(ReturnRecordRepository returnRecordRepository) {
		this.returnRecordRepository = returnRecordRepository;
	}
	
	public void createReturnRecord(CreateReturnRecordRequest returnrecordRequest) {
		ReturnRecord  returnRecord = mapToEntity(returnrecordRequest);
		returnRecordRepository.save(returnRecord);
		
	}
	
	
	public ReturnRecord mapToEntity(CreateReturnRecordRequest returnRecordRequest) {
		ReturnRecord rr = new ReturnRecord();
		rr.setAmazonOrderId(returnRecordRequest.amazonOrderId());
		rr.setOriginalZoroOrderId(returnRecordRequest.originalZoroOrderId());
		rr.setApprovedBy(returnRecordRequest.approvedBy());
		rr.setFromAddress(returnRecordRequest.fromAddress());
		rr.setResolutionType(returnRecordRequest.resolutionType());
		rr.setReturnAuthorizationNumber(returnRecordRequest.returnAuthorizationNumber());
		rr.setQuantity(returnRecordRequest.returnedQuantity());
		rr.setStatus(returnRecordRequest.status());
		rr.setToAddress(returnRecordRequest.toAddress());
		return rr;
	}

}
