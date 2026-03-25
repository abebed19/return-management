package com.example.returnmanagement.model;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ShipmentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="replacement_shipments")
public class ReplacementShipment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String trackingNumber;
	@Column(nullable = false)
	private String carrier;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private LocalDateTime shippedAt;
	private LocalDateTime deliveredAt;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ShipmentStatus status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name ="replacement_order_id",nullable = false)
	private ReplacementOrder replacementOrder;
	
	public ReplacementShipment() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getShippedAt() {
		return shippedAt;
	}

	public void setShippedAt(LocalDateTime shippedAt) {
		this.shippedAt = shippedAt;
	}

	public LocalDateTime getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(LocalDateTime deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

	public ShipmentStatus getStatus() {
		return status;
	}

	public void setStatus(ShipmentStatus status) {
		this.status = status;
	}

	public ReplacementOrder getReplacementOrder() {
		return replacementOrder;
	}

	public void setReplacementOrder(ReplacementOrder replacementOrder) {
		this.replacementOrder = replacementOrder;
	}
}
