package com.example.returnmanagement.dto;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ShipmentStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateReturnShipmentDto(
		@NotBlank(message = "Tracking number required")
		String trackingNumber,
		@NotBlank(message = "Carrier should be given")
	    String carrier,
	    @NotNull(message = "Quantity must be known")
	    Integer quantity,
	    LocalDateTime deliveredAt,
	    @NotNull(message = "Please provide the shipmentStatus")
	    ShipmentStatus status
		) {}
