package org.springmvc.zaidi_malak_exam_jee.entities;

import jakarta.persistence.Entity;

@Entity
public class PersonalCredit extends Credit {
    private String motif;

    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
}
