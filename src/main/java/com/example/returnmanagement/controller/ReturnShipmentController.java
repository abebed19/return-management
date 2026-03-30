package com.example.returnmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.returnmanagement.dto.CreateReturnShipmentDto;
import com.example.returnmanagement.dto.ReturnShipmentDto;
import com.example.returnmanagement.service.ReturnShipmentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/returns/{returnId}/shipments")
public class ReturnShipmentController {
	
	private final ReturnShipmentService returnShipmentService;
	
	public ReturnShipmentController(ReturnShipmentService returnShipmentService) {
		
		this.returnShipmentService =  returnShipmentService;
		
	}
	
	@PostMapping
	public ResponseEntity<ReturnShipmentDto> createShipment(@PathVariable Long returnId,@Valid @RequestBody CreateReturnShipmentDto shipmentDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(returnShipmentService.createReturnShipment(returnId, shipmentDto));
		
	}
	@GetMapping
	public ResponseEntity<List<ReturnShipmentDto>> getShipmentsByReturnId(@PathVariable Long returnId){
		return ResponseEntity.ok(returnShipmentService.getReturnShipments(returnId));
	}
	@GetMapping("/{shipmentId}")
	public ResponseEntity<ReturnShipmentDto> getShipment(@PathVariable("returnId") Long returnId, @PathVariable("shipmentId") Long shipmentId){
		return ResponseEntity.ok(returnShipmentService.getShipment(returnId,shipmentId));
	}

}
