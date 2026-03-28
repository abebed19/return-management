package com.example.returnmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.returnmanagement.dto.CreateReturnShipmentDto;
import com.example.returnmanagement.dto.ReturnShipmentDto;
import com.example.returnmanagement.service.ReturnShipmentService;


@RestController
@RequestMapping("/api/returns/{returnId}/shipments")
public class ReturnShipmentController {
	
	private final ReturnShipmentService returnShipmentService;
	
	public ReturnShipmentController(ReturnShipmentService returnShipmentService) {
		
		this.returnShipmentService =  returnShipmentService;
		
	}
	
	@PostMapping
	public ResponseEntity<ReturnShipmentDto> createShipment(@PathVariable Long returnId, CreateReturnShipmentDto shipmentDto){
		return ResponseEntity.ok(returnShipmentService.createReturnShipment(returnId, shipmentDto));
		
	}
	

}
