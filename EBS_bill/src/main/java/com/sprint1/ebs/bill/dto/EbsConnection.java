package com.sprint1.ebs.bill.dto;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sprint1.ebs.bill.entitie.Bill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 

enum EconnectionType{
    phase1, phase2;
    }

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbsConnection {
  
    private Long connID;
    private Set<Long> billID;
    private Long customerID;
    private EconnectionType type;
    
}