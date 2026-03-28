package com.example.returnmanagement.service;

import com.example.returnmanagement.dto.CreateReturnShipmentDto;
import com.example.returnmanagement.dto.ReturnShipmentDto;
import com.example.returnmanagement.exception.ReturnRecordNotFound;
import com.example.returnmanagement.mapper.ReturnShipmentMapper;
import com.example.returnmanagement.model.ReturnRecord;
import com.example.returnmanagement.model.ReturnShipment;
import com.example.returnmanagement.repository.ReturnRecordRepository;
import com.example.returnmanagement.repository.ReturnShipmentRepository;

public class ReturnShipmentService {
	
	private final ReturnRecordRepository returnRecordRepository;
	private final ReturnShipmentMapper returnShipmentMapper;
	private final ReturnShipmentRepository returnShipmentRepository;
	

	public ReturnShipmentService(ReturnRecordRepository returnRecordRepository, 
			ReturnShipmentRepository returnShipmentRepository,
			ReturnShipmentMapper returnShipmentMapper
			) {
		
		this.returnShipmentMapper = returnShipmentMapper;
		this.returnShipmentRepository = returnShipmentRepository;
		this.returnRecordRepository  = returnRecordRepository;
	}

	public ReturnShipmentDto createReturnShipment(Long returnRecordId, CreateReturnShipmentDto shipmentDto) {
		 
		
		  ReturnRecord returnRecord = returnRecordRepository.findById(returnRecordId)
                  .orElseThrow(()-> new ReturnRecordNotFound("Return record with id "+ returnRecordId+" not found"));
		  ReturnShipment returnShipment = returnShipmentMapper.createReturnShipmentDtoToEntity(shipmentDto);
		  returnShipment.setReturnRecord(returnRecord);
		  
		  
		  
		  
	}
	

}
