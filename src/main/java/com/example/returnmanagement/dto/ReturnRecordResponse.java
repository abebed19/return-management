package com.example.returnmanagement.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;
 
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
		AddressDto toAddress
	
		) {}
