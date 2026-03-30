package com.example.returnmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.returnmanagement.model.ReturnRecord;
import com.example.returnmanagement.model.ReturnShipment;

public interface ReturnShipmentRepository extends JpaRepository<ReturnShipment, Long> {
	
	public List<ReturnShipment> findByReturnRecord(ReturnRecord returnRecord);
	public ReturnShipment findByIdAndReturnRecord(Long id, ReturnRecord returnRecord);

}
