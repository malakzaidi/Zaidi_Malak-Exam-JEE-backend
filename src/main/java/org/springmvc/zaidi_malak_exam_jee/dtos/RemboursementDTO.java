package org.springmvc.zaidi_malak_exam_jee.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private Double montant;
    private String type;
    private Long creditId;


}