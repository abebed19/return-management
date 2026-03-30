package com.example.returnmanagement.dto;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ShipmentStatus;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CreateReturnShipmentDto(
		@NotBlank(message = "Tracking number required")
		String trackingNumber,
		@NotBlank(message = "Carrier should be given")
	    String carrier,
	    @NotNull(message = "Quantity must be known")
		@Positive(message = "Quantity must be greater than zero")
	    Integer quantity,
	    LocalDateTime deliveredAt,
	    @NotNull(message = "Please provide the shipmentStatus")
	    ShipmentStatus status
		) {}
