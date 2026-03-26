package com.example.returnmanagement.dto;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;
import com.example.returnmanagement.model.Address;

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
