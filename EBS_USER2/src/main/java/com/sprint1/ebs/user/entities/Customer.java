package com.sprint1.ebs.user.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class Customer extends User{
		
	@NotNull
	@Size(min=3, max=30)
	private String custName;
	@NotNull
	@Column(unique=true)
	private String phoneNumber;
	private String custAddress;
	@ElementCollection
	private List<Long> ebsConnectionID;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public List<Long> getEbsConnectionID() {
		return ebsConnectionID;
	}
	public void setEbsConnectionID(List<Long> ebsConnectionID) {
		this.ebsConnectionID = ebsConnectionID;
	}

	public Customer(@NotNull @Size(min = 3, max = 30) String custName, @NotNull String phoneNumber, String custAddress,
			List<Long> ebsConnectionID) {
		super();
		this.custName = custName;
		this.phoneNumber = phoneNumber;
		this.custAddress = custAddress;
		this.ebsConnectionID = ebsConnectionID;
	}
	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", phoneNumber=" + phoneNumber + ", custAddress=" + custAddress
				+ ", ebsConnectionID=" + ebsConnectionID + "]";
	}
	
	
}
