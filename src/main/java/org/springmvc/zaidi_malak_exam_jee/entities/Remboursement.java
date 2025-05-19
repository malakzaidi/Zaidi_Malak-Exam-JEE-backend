package org.springmvc.zaidi_malak_exam_jee.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double montant;
    private String type;

    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

}