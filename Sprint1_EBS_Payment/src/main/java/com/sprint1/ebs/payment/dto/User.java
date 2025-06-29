package com.sprint1.ebs.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


	private Long userID;
	private String userRole;
	private String password;
	private String email;
}
