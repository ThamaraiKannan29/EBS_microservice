package com.sprint1.ebs.connection.service;

import java.util.List;

import com.sprint1.ebs.connection.entities.EbsConnection;
import com.sprint1.ebs.connection.exception.EbsConnectionIDNotFoundException;


public interface EbsConnectionService {	
	
	EbsConnection createEbsConnection(EbsConnection connection);
	List<EbsConnection> getEbsConnectionByCustomerID(Long custID);
	//EbsConnection getEbsConnectionById(Long id) throws EbsCustomerIDNotFoundException;
	EbsConnection listByID(Long connID) throws EbsConnectionIDNotFoundException;
}

