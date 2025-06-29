package com.sprint1.ebs.user.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	private Long paymentID;
	private Long billID;
	private LocalDate paymentDate;
}
