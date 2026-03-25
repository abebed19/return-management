package com.example.returnmanagement.model;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.TargetType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name= "notes")
public class Note {
	@Id
	@GeneratedValue (strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false)
	private String createdBy;
	@Column(nullable = false,updatable = false)
	private LocalDateTime createdAt;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TargetType targetType;
	
	
	@Column(nullable = false)
	private Long targetId;
	
	public Note() {
		
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public LocalDateTime getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	public TargetType getTargetType() {
		return targetType;
	}



	public void setTargetType(TargetType targetType) {
		this.targetType = targetType;
	}
	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	@PrePersist
	public void prePersist() {
		if(this.createdAt == null)
			this.createdAt  = LocalDateTime.now();
	}
	
	
	

}
