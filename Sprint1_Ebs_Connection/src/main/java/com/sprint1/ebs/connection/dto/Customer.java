package com.sprint1.ebs.connection.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.sprint1.ebs.connection.entities.EbsConnection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
		
	private String custName;
	private String phoneNumber;
	private String custAddress;
	
	private List<Long> ebsConnectionID;
}