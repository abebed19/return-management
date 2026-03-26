package com.example.returnmanagement.dto;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ShipmentStatus;

public record ReturnShipmentDto(
		    String trackingNumber,
		    String carrier,
		    int quantity,
		    LocalDateTime shippedAt,
		    LocalDateTime deliveredAt,
		    ShipmentStatus status
) {}
