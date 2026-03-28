package com.example.returnmanagement.mapper;

import org.springframework.stereotype.Component;

import com.example.returnmanagement.dto.CreateReturnShipmentDto;
import com.example.returnmanagement.model.ReturnShipment;

@Component
public class ReturnShipmentMapper {
	
	
	public  ReturnShipment createReturnShipmentDtoToEntity(CreateReturnShipmentDto shipmentDto) {
    	ReturnShipment returnShipment = new ReturnShipment();
    	returnShipment.setTrackingNumber(shipmentDto.trackingNumber());
    	returnShipment.setCarrier(shipmentDto.carrier());
    	returnShipment.setQuantity(shipmentDto.quantity());
    	returnShipment.setDeliveredAt(shipmentDto.deliveredAt());
    	returnShipment.setStatus(shipmentDto.status());
    	return returnShipment;
    }

}
