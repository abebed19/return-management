package com.example.returnmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.returnmanagement.model.ReturnShipment;

public interface ReturnShipmentRepository extends JpaRepository<ReturnShipment, Long> {

}
