package org.springmvc.zaidi_malak_exam_jee.entities;

import jakarta.persistence.Entity;

@Entity
public class ImmobilierCredit extends Credit {
    private String typeBien; // Appartement, Maison, Local Commercial

    // Getter and Setter
    public String getTypeBien() { return typeBien; }
    public void setTypeBien(String typeBien) { this.typeBien = typeBien; }
}