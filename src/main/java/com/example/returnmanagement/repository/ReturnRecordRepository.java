package com.example.returnmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.returnmanagement.model.ReturnRecord;

@Repository
public interface ReturnRecordRepository extends JpaRepository<ReturnRecord,Long> {

}
