package com.example.returnmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.returnmanagement.enums.ReturnRecordStatus;
import com.example.returnmanagement.model.ReturnRecord;

@Repository
public interface ReturnRecordRepository extends JpaRepository<ReturnRecord,Long> {
	
	public List<ReturnRecord> findByStatus(ReturnRecordStatus status);

}
