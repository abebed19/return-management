package com.example.returnmanagement.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;
import com.example.returnmanagement.model.Address;
import com.example.returnmanagement.model.ReplacementOrder;
import com.example.returnmanagement.model.ReturnShipment;

public record ReturnRecordResponse(
		long id,
		String amazonOrderId,
		String originalZoroOrderId,
		String returnAuthorizationNumber,
		String approvedBy,
		int returnedQuantity,
		ResolutionType resolutionType,
		ReturnRecordStatus status,
		LocalDateTime createdAt,
		LocalDateTime updatedAt,
		AddressDto fromAddress,
		AddressDto toAddress,
		List<ReturnShipmentDto> shipments,
		ReplacementOrderDto replacementOrder
		) {}
