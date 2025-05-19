package org.springmvc.zaidi_malak_exam_jee.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateDemande;
    private String statut; // En cours, Accepté, Rejeté
    private LocalDate dateAcception;
    private Double montant;
    private Integer dureeRemboursement;
    private Double tauxInteret;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "credit", cascade = CascadeType.ALL)
    private List<Remboursement> remboursements;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateDemande() { return dateDemande; }
    public void setDateDemande(LocalDate dateDemande) { this.dateDemande = dateDemande; }
    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }
    public LocalDate getDateAcception() { return dateAcception; }
    public void setDateAcception(LocalDate dateAcception) { this.dateAcception = dateAcception; }
    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
    public Integer getDureeRemboursement() { return dureeRemboursement; }
    public void setDureeRemboursement(Integer dureeRemboursement) { this.dureeRemboursement = dureeRemboursement; }
    public Double getTauxInteret() { return tauxInteret; }
    public void setTauxInteret(Double tauxInteret) { this.tauxInteret = tauxInteret; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<Remboursement> getRemboursements() { return remboursements; }
    public void setRemboursements(List<Remboursement> remboursements) { this.remboursements = remboursements; }
}