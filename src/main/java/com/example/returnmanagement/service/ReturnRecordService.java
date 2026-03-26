package com.example.returnmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.returnmanagement.dto.AddressDto;
import com.example.returnmanagement.dto.CreateReturnRecordRequest;
import com.example.returnmanagement.dto.ReplacementOrderDto;
import com.example.returnmanagement.dto.ReturnRecordResponse;
import com.example.returnmanagement.dto.ReturnShipmentDto;
import com.example.returnmanagement.model.Address;
import com.example.returnmanagement.model.ReplacementOrder;
import com.example.returnmanagement.model.ReturnRecord;
import com.example.returnmanagement.model.ReturnShipment;
import com.example.returnmanagement.repository.ReturnRecordRepository;
import com.example.returnmanagement.exception.ReturnRecordNotFound;

@Service
public class ReturnRecordService {
	
	private final ReturnRecordRepository returnRecordRepository;
	
	public ReturnRecordService(ReturnRecordRepository returnRecordRepository) {
		this.returnRecordRepository = returnRecordRepository;
	}
	
	public ReturnRecordResponse createReturnRecord(CreateReturnRecordRequest returnrecordRequest) {
		ReturnRecord  returnRecord = mapToEntity(returnrecordRequest);
		ReturnRecord  saved = returnRecordRepository.save(returnRecord);
		ReturnRecordResponse response =mapToReturnRecordResponse(saved);
		return response;
	}
	
	
	public ReturnRecordResponse findReturnRecordById(Long id) {
		ReturnRecord  returnRecord = returnRecordRepository.findById(id)
				                     .orElseThrow(()->new ReturnRecordNotFound("Return record with id "+ id+" not found"));
		return mapToReturnRecordResponse(returnRecord);
	}
	
	public List<ReturnRecordResponse> findReturnRecords(){
		List<ReturnRecordResponse> records = returnRecordRepository.findAll()
				                             .stream()
				                             .map(returnRecord ->mapToReturnRecordResponse(returnRecord))
				                             .toList();
		return records;
	}
	
	private ReturnRecord mapToEntity(CreateReturnRecordRequest returnRecordRequest) {
		ReturnRecord rr = new ReturnRecord();
		rr.setAmazonOrderId(returnRecordRequest.amazonOrderId());
		rr.setOriginalZoroOrderId(returnRecordRequest.originalZoroOrderId());
		rr.setApprovedBy(returnRecordRequest.approvedBy());
		rr.setFromAddress(toAddressEntity(returnRecordRequest.fromAddress()));
		rr.setResolutionType(returnRecordRequest.resolutionType());
		rr.setReturnAuthorizationNumber(returnRecordRequest.returnAuthorizationNumber());
		rr.setReturnedQuantity(returnRecordRequest.returnedQuantity());
		rr.setStatus(returnRecordRequest.status());
		rr.setToAddress(toAddressEntity(returnRecordRequest.toAddress()));
		return rr;
	}
	
  private ReturnRecordResponse mapToReturnRecordResponse(ReturnRecord returnRecord) {
		return new ReturnRecordResponse(
				returnRecord.getId(),
				returnRecord.getAmazonOrderId(),
				returnRecord.getOriginalZoroOrderId(),
				returnRecord.getReturnAuthorizationNumber(),
				returnRecord.getApprovedBy(),
				returnRecord.getReturnedQuantity(),
				returnRecord.getResolutionType(),
				returnRecord.getStatus(),
				returnRecord.getCreatedAt(),
				returnRecord.getUpdatedAt(),
				toAddressDto(returnRecord.getFromAddress()),
				toAddressDto(returnRecord.getToAddress())
		);
	}
 
     private Address toAddressEntity(AddressDto addressDto) {
    	 
    	 Address address  = new Address();
    	 address.setFullName(addressDto.fullName());
    	 address.setCompanyName(addressDto.companyName());
    	 address.setPhone(addressDto.phone());
    	 address.setAddressLine1(addressDto.addressLine1());
    	 address.setAddressLine2(addressDto.addressLine2());
    	 address.setState(addressDto.state());
    	 address.setPostalCode(addressDto.postalCode());
    	 address.setCity(addressDto.city());
    	 address.setCountry(addressDto.country());
    	 return address;
     }
     private AddressDto  toAddressDto(Address address)
     {
    	 return new AddressDto(
    			 address.getFullName(),
    			 address.getCompanyName(),
    			 address.getPhone(),
    			 address.getAddressLine1(),
    			 address.getAddressLine2(),
    			 address.getCity(),
    			 address.getState(),
    			 address.getPostalCode(),
    			 address.getCountry());
    			 
     }
     
    private List<ReturnShipmentDto> toReturnShipmentDto(List<ReturnShipment> shipmentEntity) {
    	List<ReturnShipmentDto> returnshipments= new ArrayList<>();
  
    	for(ReturnShipment shipment : shipmentEntity) {
    		returnshipments.add(new ReturnShipmentDto(
    				shipment.getTrackingNumber(),
    				shipment.getCarrier(),
    				shipment.getQuantity(),
    				shipment.getShippedAt(),
    				shipment.getDeliveredAt(),
    				shipment.getStatus()));
    	}
    	return returnshipments;
    }
    
    
    private ReplacementOrderDto toReplacementOrderDto(ReplacementOrder order) {
    	
      return new ReplacementOrderDto(
    		    order.getId(),
    		    order.getReplacementZoroOrderNumber(),
    		    order.getProcessedAt(),
    		    order.getReplacedQuantity(),
    		    order.getStatus(),
    		    toAddressDto(order.getFromAddress()),
    		    toAddressDto(order.getToAddress()));
    		  
    }
}
