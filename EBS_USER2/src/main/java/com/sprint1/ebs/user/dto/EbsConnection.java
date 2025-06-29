package com.sprint1.ebs.user.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum EconnectionType{
    phase1, phase2;
    }

@AllArgsConstructor
@NoArgsConstructor
public class EbsConnection {

    private Long connID;
    
    private Set<Long> billID;

    private Long customerID;
   
    private EconnectionType type;

	public Long getConnID() {
		return connID;
	}

	public void setConnID(Long connID) {
		this.connID = connID;
	}

	public Set<Long> getBillID() {
		return billID;
	}

	public void setBillID(Set<Long> billID) {
		this.billID = billID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public EconnectionType getType() {
		return type;
	}

	public void setType(EconnectionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EbsConnection [connID=" + connID + ", billID=" + billID + ", customerID=" + customerID + ", type="
				+ type + "]";
	}
    
    
}
