package com.example.returnmanagement.dto;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;

public record CreateReturnRecordRequest(
		String amazonOrderId,
		String originalZoroOrderId,
		String returnAuthorizationNumber,
		String approvedBy,
		int returnedQuantity,
		ResolutionType resolutionType,
		ReturnRecordStatus status,
		AddressDto fromAddress,
		AddressDto toAddress
		
) {}
