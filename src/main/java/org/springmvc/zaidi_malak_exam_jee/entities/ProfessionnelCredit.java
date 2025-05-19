package org.springmvc.zaidi_malak_exam_jee.entities;

import jakarta.persistence.Entity;

@Entity
public class ProfessionnelCredit extends Credit {
    private String motif;
    private String raisonSociale;

    // Getters and Setters
    public String getMotif() { return motif; }
    public void setMotif(String motif) { this.motif = motif; }
    public String getRaisonSociale() { return raisonSociale; }
    public void setRaisonSociale(String raisonSociale) { this.raisonSociale = raisonSociale; }
}
