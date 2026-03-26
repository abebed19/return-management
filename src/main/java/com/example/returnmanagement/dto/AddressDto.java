package com.example.returnmanagement.dto;

public record AddressDto(String fullName,
		String companyName,
		String phone,
		String addressLine1,
		String addressLine2,
		String city,
		String state,
		String postalCode,
		String country
){}
