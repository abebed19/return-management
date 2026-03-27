package com.example.returnmanagement.dto;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;

import jakarta.validation.constraints.NotBlank;

public record CreateReturnRecordRequest(
		@NotBlank(message = "Amazon order id is required") String amazonOrderId,
		@NotBlank(message = "Zoro order id is empty") String originalZoroOrderId,
		@NotBlank(message = "Return authorization number is required") String returnAuthorizationNumber,
		@NotBlank(message = "Approved by is required") String approvedBy,
		@NotBlank (message = "Return quantity is required") int returnedQuantity,
		@NotBlank(message = "Resoultion type must be given")ResolutionType resolutionType,
		@NotBlank(message = "Current return record status must be know") ReturnRecordStatus status,
		AddressDto fromAddress,
		AddressDto toAddress
		
) {}
