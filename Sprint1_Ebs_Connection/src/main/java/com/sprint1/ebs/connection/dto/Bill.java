package com.sprint1.ebs.connection.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sprint1.ebs.connection.entities.EbsConnection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Bill {
    
    private Long billID;
    private double units;
    private LocalDate billGenerationDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status; 
    
     private Long ebscCnnectionID;
}