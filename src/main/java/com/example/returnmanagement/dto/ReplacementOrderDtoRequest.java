package com.example.returnmanagement.dto;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ReplacementOrderStatus;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ReplacementOrderDtoRequest(
		@NotBlank(message ="Replacement zoro order number is required")
		String replacementZoroOrderNumber,
		@NotNull(message = "Quantity is required")
		@Positive(message  ="replacment order quantity must be non zero and positive")
		Integer replacedQuantity,
		@NotNull(message = "Replacement order status is required")
		ReplacementOrderStatus status,
		@Valid
		AddressDto fromAddress,
		@Valid
		AddressDto toAddress
		) {}
