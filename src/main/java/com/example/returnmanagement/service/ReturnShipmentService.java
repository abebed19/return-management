package com.example.returnmanagement.service;

import com.example.returnmanagement.dto.CreateReturnShipmentDto;
import com.example.returnmanagement.dto.ReturnShipmentDto;
import com.example.returnmanagement.exception.ReturnRecordNotFound;
import com.example.returnmanagement.model.ReturnRecord;
import com.example.returnmanagement.model.ReturnShipment;
import com.example.returnmanagement.repository.ReturnRecordRepository;
import com.example.returnmanagement.repository.ReturnShipmentRepository;

public class ReturnShipmentService {
	
	private final ReturnRecordRepository returnRecordRepository;
	private final ReturnShipmentRepository returnShipmentRepository;
	

	public ReturnShipmentService(ReturnRecordRepository returnRecordRepository, ReturnShipmentRepository returnShipmentRepository) {
		
		this.returnShipmentRepository = returnShipmentRepository;
		this.returnRecordRepository  = returnRecordRepository;
	}

	public ReturnShipmentDto createReturnShipment(Long returnRecordId, CreateReturnShipmentDto shipmentDto) {
		 
		
		  ReturnRecord returnRecord = returnRecordRepository.findById(returnRecordId)
                  .orElseThrow(()-> new ReturnRecordNotFound("Return record with id "+ returnRecordId+" not found"));
		
		  ReturnShipment returnShipment = createReturnShipmentDtoToEntity(shipmentDto);
		  returnShipment.setReturnRecord(returnRecord);
		  
		  
		  
	}
	
	public ReturnShipment createReturnShipmentDtoToEntity(CreateReturnShipmentDto shipmentDto) {
    	ReturnShipment returnShipment = new ReturnShipment();
    	returnShipment.setTrackingNumber(shipmentDto.trackingNumber());
    	returnShipment.setCarrier(shipmentDto.carrier());
    	returnShipment.setQuantity(shipmentDto.quantity());
    	returnShipment.setDeliveredAt(shipmentDto.deliveredAt());
    	returnShipment.setStatus(shipmentDto.status());
    	return returnShipment;
    }
}
