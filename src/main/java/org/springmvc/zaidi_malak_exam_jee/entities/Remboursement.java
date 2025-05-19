package org.springmvc.zaidi_malak_exam_jee.entities;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Double getMontant() { return montant; }
    public void setMontant(Double montant) { this.montant = montant; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Credit getCredit() { return credit; }
    public void setCredit(Credit credit) { this.credit = credit; }
}