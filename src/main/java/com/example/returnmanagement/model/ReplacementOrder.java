package com.example.returnmanagement.model;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ReplacementOrderStatus;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "replacement_orders")
public class ReplacementOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String replacementZoroOrderNumber;
	@Column(nullable = false,updatable = false)
	private LocalDateTime processedAt;
	@Column(nullable = false)
	private Long replacedQuantity;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ReplacementOrderStatus status;
	@Embedded
	@AttributeOverrides({
		   @AttributeOverride(name = "fullName", column = @Column(name="from_full_name")),
		   @AttributeOverride(name = "companyName", column = @Column(name = "from_company_name")),
	       @AttributeOverride(name = "phone", column = @Column(name = "from_phone")),
	       @AttributeOverride(name = "addressLine1", column = @Column(name = "from_address_line1")),
	       @AttributeOverride(name = "addressLine2", column = @Column(name = "from_address_line2")),
	       @AttributeOverride(name = "city", column = @Column(name = "from_city")),
	       @AttributeOverride(name = "state", column = @Column(name = "from_state")),
	       @AttributeOverride(name = "postalCode", column = @Column(name = "from_postal_code")),
	       @AttributeOverride(name = "country", column = @Column(name = "from_country"))
	})
	private Address fromAddress;
	
	@Embedded
	@AttributeOverrides({
		   @AttributeOverride(name = "fullName", column = @Column(name="to_full_name")),
		   @AttributeOverride(name = "companyName", column = @Column(name = "to_company_name")),
	       @AttributeOverride(name = "phone", column = @Column(name = "to_phone")),
	       @AttributeOverride(name = "addressLine1", column = @Column(name = "to_address_line1")),
	       @AttributeOverride(name = "addressLine2", column = @Column(name = "to_address_line2")),
	       @AttributeOverride(name = "city", column = @Column(name = "to_city")),
	       @AttributeOverride(name = "state", column = @Column(name = "to_state")),
	       @AttributeOverride(name = "postalCode", column = @Column(name = "to_postal_code")),
	       @AttributeOverride(name = "country", column = @Column(name = "to_country"))
	})
	private Address toAddress;
	
	@OneToOne(optional = false)
	@JoinColumn(name ="return_record_id",nullable = false, unique = true)
	private ReturnRecord returnRecord;
	public ReplacementOrder() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReplacementZoroOrderNumber() {
		return replacementZoroOrderNumber;
	}
	public void setReplacementZoroOrderNumber(String replacementZoroOrderNumber) {
		this.replacementZoroOrderNumber = replacementZoroOrderNumber;
	}
	public LocalDateTime getProcessedAt() {
		return processedAt;
	}
	public void setProcessedAt(LocalDateTime processedAt) {
		this.processedAt = processedAt;
	}
	public Long getReplacedQuantity() {
		return replacedQuantity;
	}
	public void setReplacedQuantity(Long replacedQuantity) {
		this.replacedQuantity = replacedQuantity;
	}
	public ReplacementOrderStatus getStatus() {
		return status;
	}
	public void setStatus(ReplacementOrderStatus status) {
		this.status = status;
	}
	public Address getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(Address fromAddress) {
		this.fromAddress = fromAddress;
	}
	public Address getToAddress() {
		return toAddress;
	}
	public void setToAddress(Address toAddress) {
		this.toAddress = toAddress;
	}
	public ReturnRecord getReturnRecord() {
		return returnRecord;
	}
	public void setReturnRecord(ReturnRecord returnRecord) {
		this.returnRecord = returnRecord;
	}
	
	
	

}
