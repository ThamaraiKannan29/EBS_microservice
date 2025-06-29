package com.sprint1.ebs.bill.service;

import java.util.List;
//import java.util.Optional;
//
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sprint1.ebs.bill.dto.EbsConnection;
import com.sprint1.ebs.bill.entitie.Bill;
import com.sprint1.ebs.bill.exception.BillNotFoundException;

public interface BillService {
	Bill createBill(Bill bill);
	Bill updateBill(Bill bill,Long id)throws BillNotFoundException;
	List<Bill> listAll();
	List<Bill> listAllPaidOrUnpaid(boolean status);
	Bill listById(Long billID) throws BillNotFoundException;
	List<Bill> listAllBill(Long ConnID);
	List<Bill> listAllPaidOrUnpaidByConnID(long connID, boolean status);

}
