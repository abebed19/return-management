package com.example.returnmanagement.dto;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ReplacementOrderStatus;

public record ReplacementOrderDto(
		long id,
		String replacementZoroOrderNumber,
		LocalDateTime processedAt,
		int replacedQuantity,
		ReplacementOrderStatus status,
		AddressDto fromAddress,
		AddressDto toAddress
		) {}
