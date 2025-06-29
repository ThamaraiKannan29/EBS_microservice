package com.sprint1.ebs.bill.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.ebs.bill.dto.EbsConnection;
import com.sprint1.ebs.bill.entitie.Bill;
import com.sprint1.ebs.bill.exception.BillNotFoundException;
import com.sprint1.ebs.bill.repo.BillRepo;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillRepo repo;

	@Override
	public Bill createBill(Bill bill) {
		// TODO Auto-generated method stub
		bill.setBillGenerationDate(LocalDate.now());
		LocalDate s=bill.getBillGenerationDate().minusMonths(1L);
		
		LocalDate s1=s.withDayOfMonth(1);
		bill.setStartDate(s1);
		
		LocalDate end=s.withDayOfMonth(s.lengthOfMonth());
		bill.setEndDate(end);
		      
		bill.setBillAmount(bill.getUnits()*5.36);
		return repo.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill, Long id) throws BillNotFoundException {
		// TODO Auto-generated method stub
		Bill b1=repo.findById(id).orElseThrow(()->new BillNotFoundException("ID not found"));		
		b1.setUnits(bill.getUnits());
		b1.setBillAmount(b1.getUnits()*15.3);
		return repo.save(b1);
	}

	@Override
	public List<Bill> listAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Bill> listAllPaidOrUnpaid(boolean status) {
		// TODO Auto-generated method stub
		return repo.findAllByStatus(status);
	}

	@Override
	public Bill listById(Long billID) throws BillNotFoundException {
		// TODO Auto-generated method stub
     	return repo.findById(billID).orElseThrow(()->new BillNotFoundException("ID Not Found"));
	}

	@Override
	public List<Bill> listAllBill(Long connID) {
		// TODO Auto-generated method stub
		return repo.findAllByConnID(connID);
	}

	@Override
	public List<Bill> listAllPaidOrUnpaidByConnID(long connID, boolean status) {
		// TODO Auto-generated method stub
		return repo.findAllByConnIDOrStatus(connID,status);
	}
	
	
	
	

}
