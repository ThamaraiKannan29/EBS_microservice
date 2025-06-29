package com.sprint1.ebs.payment.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
	private String custName;
	private String phoneNumber;
	private String custAddress;
	private List<Long> ebsConnectionID;
}
