package com.example.returnmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.returnmanagement.dto.CreateReturnShipmentDto;
import com.example.returnmanagement.dto.ReturnShipmentDto;
import com.example.returnmanagement.enums.ShipmentStatus;
import com.example.returnmanagement.exception.ReturnRecordNotFound;
import com.example.returnmanagement.exception.ReturnShipmentNotFoundException;
import com.example.returnmanagement.mapper.ReturnShipmentMapper;
import com.example.returnmanagement.model.ReturnRecord;
import com.example.returnmanagement.model.ReturnShipment;
import com.example.returnmanagement.repository.ReturnRecordRepository;
import com.example.returnmanagement.repository.ReturnShipmentRepository;

@Service
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
		  ReturnShipment returnShipment = returnShipmentMapper.toEntity(shipmentDto);
		  returnShipment.setReturnRecord(returnRecord);
		  ReturnShipment saved = returnShipmentRepository.save(returnShipment);
		  return returnShipmentMapper.toDto(saved);
		  
	}
	
	public List<ReturnShipmentDto> getReturnShipments(Long returnId){
		
		ReturnRecord returnRecord =   returnRecordRepository.findById(returnId)
                .orElseThrow(()-> new ReturnRecordNotFound("Return record with id "+ returnId+" not found"));
		
	    return	returnShipmentRepository.findByReturnRecord(returnRecord)
	                            .stream()
	                            .map(returnShipmentMapper::toDto)
	                            .toList();
	}
	
	public ReturnShipmentDto getShipment(Long returnId, Long shipmentId ) {
		ReturnRecord returnRecord =   returnRecordRepository.findById(returnId)
                .orElseThrow(()-> new ReturnRecordNotFound("Return record with id "+ returnId+" not found "));

		return returnShipmentMapper.toDto(
				returnShipmentRepository.findByIdAndReturnRecord(shipmentId, returnRecord)
				.orElseThrow(()->new ReturnShipmentNotFoundException("Return shipment with id"+ shipmentId+" not found  for return record "+ returnId))
				);
		
	}
	
	public ReturnShipmentDto updateShipment(Long returnId, Long shipmentId,CreateReturnShipmentDto shipmentDto) {
		ReturnRecord returnRecord =   returnRecordRepository.findById(returnId)
                .orElseThrow(()-> new ReturnRecordNotFound("Return record with id "+ returnId+" not found "));
		ReturnShipment returnShipment = returnShipmentRepository.findByIdAndReturnRecord(shipmentId, returnRecord)
				.orElseThrow(()->new ReturnShipmentNotFoundException("Return shipment with id " + shipmentId + " not found for return record " + returnId));
		
		returnShipment.setCarrier(shipmentDto.carrier());
		returnShipment.setQuantity(shipmentDto.quantity());
		returnShipment.setTrackingNumber(shipmentDto.trackingNumber());
		returnShipment.setStatus(shipmentDto.status());
		if(returnShipment.getStatus() == ShipmentStatus.DELIVERED && returnShipment.getDeliveredAt() == null)
			returnShipment.setDeliveredAt(LocalDateTime.now());
		
		return returnShipmentMapper.toDto(returnShipmentRepository.save(returnShipment));
	}
	
	public void deleteShipment(Long returnId, Long shipmentId) {
		ReturnRecord returnRecord =   returnRecordRepository.findById(returnId)
                .orElseThrow(()-> new ReturnRecordNotFound("Return record with id "+ returnId+" not found "));
		ReturnShipment returnShipment = returnShipmentRepository.findByIdAndReturnRecord(shipmentId, returnRecord)
				.orElseThrow(()->new ReturnShipmentNotFoundException("Return shipment with id " + shipmentId + " not found "));
		returnShipmentRepository.delete(returnShipment);
		
	
	}

}
