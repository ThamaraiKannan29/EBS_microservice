package com.sprint1.ebs.bill.entitie;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sprint1.ebs.bill.dto.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bill")
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	@Override
	public String toString() {
		return "Bill [billID=" + billID + ", units=" + units + ", billGenerationDate=" + billGenerationDate
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", billAmount="
				+ billAmount + ", connID=" + connID + ", paymentID=" + paymentID + "]";
	}


	public Long getBillID() {
		return billID;
	}


	public void setBillID(Long billID) {
		this.billID = billID;
	}


	public double getUnits() {
		return units;
	}


	public void setUnits(double units) {
		this.units = units;
	}


	public LocalDate getBillGenerationDate() {
		return billGenerationDate;
	}


	public void setBillGenerationDate(LocalDate billGenerationDate) {
		this.billGenerationDate = billGenerationDate;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public double getBillAmount() {
		return billAmount;
	}


	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}


	public Long getConnID() {
		return connID;
	}


	public void setConnID(Long connID) {
		this.connID = connID;
	}


	public Long getPaymentID() {
		return paymentID;
	}


	public void setPaymentID(Long paymentID) {
		this.paymentID = paymentID;
	}


	@Id
	@GeneratedValue
	private Long billID;
    private double units;
    private LocalDate billGenerationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status; 
    private double billAmount;
    
    

	
    private Long connID;

   
    private Long paymentID;
    
}