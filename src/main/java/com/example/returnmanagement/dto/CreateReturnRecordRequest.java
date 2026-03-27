package com.example.returnmanagement.dto;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateReturnRecordRequest(
		@NotBlank(message = "Amazon order id is required") String amazonOrderId,
		@NotBlank(message = "Zoro order id is empty") String originalZoroOrderId,
		@NotBlank(message = "Return authorization number is required") String returnAuthorizationNumber,
		@NotBlank(message = "Approved by is required") String approvedBy,
		@Positive(message ="Quantity must be greater than 0")
		@Min(1)
		@NotNull (message = "Return quantity is required") Integer returnedQuantity,
		@NotNull(message = "Resoultion type must be given")ResolutionType resolutionType,
		@NotNull(message = "Current return record status must be know") ReturnRecordStatus status,
		AddressDto fromAddress,
		AddressDto toAddress
		
) {}
