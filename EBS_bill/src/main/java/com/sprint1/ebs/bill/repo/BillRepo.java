package com.sprint1.ebs.bill.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.ebs.bill.dto.EbsConnection;
import com.sprint1.ebs.bill.entitie.Bill;
@Repository
public interface BillRepo extends JpaRepository<Bill, Long>{

	List<Bill> findAllByStatus(boolean status);

	List<Bill> findAllByConnID(Long ConnID);

	List<Bill> findAllByConnIDOrStatus(long connID, boolean status);


//	Optional<Bill> findByBillGenerationDate(String Date);
//
//	Bill findByIdConnID(Long connID, String date);
	

}
