package org.springmvc.zaidi_malak_exam_jee.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ImmobilierCredit extends Credit {
    private String typeBien; // Appartement, Maison, Local Commercial
}
