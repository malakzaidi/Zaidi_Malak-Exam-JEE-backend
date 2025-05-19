package org.springmvc.zaidi_malak_exam_jee.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private String statut;
    private LocalDate dateAcception;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;
    private Long clientId;
    private String type; // Personal, Immobilier, Professionnel
    private String motif; // For Personal and Professionnel
    private String typeBien; // For Immobilier
    private String raisonSociale; // For Professionnel

}