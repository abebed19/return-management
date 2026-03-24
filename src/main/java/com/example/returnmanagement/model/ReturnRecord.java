package com.example.returnmanagement.model;

import java.time.LocalDateTime;

import com.example.returnmanagement.enums.ResolutionType;
import com.example.returnmanagement.enums.ReturnRecordStatus;

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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name ="return_records")
public class ReturnRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String amazonOrderId;
	@Column(nullable = false)
	private String originalZoroOrderId;
	
	private String returnAuthorizationNumber;
	
	@Column(nullable = false)
	private String approvedBy;
	@Column(nullable = false)
	private Integer quantity ;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ResolutionType resolutionType;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ReturnRecordStatus status;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "fullName", column = @Column(name = "from_full_name")),
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
	        @AttributeOverride(name = "fullName", column = @Column(name = "to_full_name")),
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
	  
	  public ReturnRecord() {
		  
	  }

	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
		  this.id = id;
	  }

	  public String getAmazonOrderId() {
		  return amazonOrderId;
	  }

	  public void setAmazonOrderId(String amazonOrderId) {
		  this.amazonOrderId = amazonOrderId;
	  }

	  public String getOriginalZoroOrderId() {
		  return originalZoroOrderId;
	  }

	  public void setOriginalZoroOrderId(String originalZoroOrderId) {
		  this.originalZoroOrderId = originalZoroOrderId;
	  }

	  public String getReturnAuthorizationNumber() {
		  return returnAuthorizationNumber;
	  }

	  public void setReturnAuthorizationNumber(String returnAuthorizationNumber) {
		  this.returnAuthorizationNumber = returnAuthorizationNumber;
	  }

	  public String getApprovedBy() {
		  return approvedBy;
	  }

	  public void setApprovedBy(String approvedBy) {
		  this.approvedBy = approvedBy;
	  }

	  public Integer getQuantity() {
		  return quantity;
	  }

	  public void setQuantity(Integer quantity) {
		  this.quantity = quantity;
	  }

	  public ResolutionType getResolutionType() {
		  return resolutionType;
	  }

	  public void setResolutionType(ResolutionType resolutionType) {
		  this.resolutionType = resolutionType;
	  }

	  public ReturnRecordStatus getStatus() {
		  return status;
	  }

	  public void setStatus(ReturnRecordStatus status) {
		  this.status = status;
	  }

	  public LocalDateTime getCreatedAt() {
		  return createdAt;
	  }

	  public void setCreatedAt(LocalDateTime createdAt) {
		  this.createdAt = createdAt;
	  }

	  public LocalDateTime getUpdatedAt() {
		  return updatedAt;
	  }

	  public void setUpdatedAt(LocalDateTime updatedAt) {
		  this.updatedAt = updatedAt;
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
	  
	  
	  @PrePersist
	  public void prePersist() {
		  this.createdAt = LocalDateTime.now();
		  this.updatedAt = LocalDateTime.now();
	  }
	  
	  @PreUpdate
	  public void preUpdate() {
		  this.updatedAt = LocalDateTime.now();
	  }
	
	

}
