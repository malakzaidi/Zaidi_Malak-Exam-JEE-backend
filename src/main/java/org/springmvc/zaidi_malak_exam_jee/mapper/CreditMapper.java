package org.springmvc.zaidi_malak_exam_jee.mapper;


import org.springframework.stereotype.Component;
import org.springmvc.zaidi_malak_exam_jee.dtos.CreditDTO;
import org.springmvc.zaidi_malak_exam_jee.entities.*;

@Component
public class CreditMapper {
    public CreditDTO toDTO(Credit credit) {
        CreditDTO dto = new CreditDTO();
        dto.setId(credit.getId());
        dto.setDateDemande(credit.getDateDemande());
        dto.setStatut(credit.getStatut());
        dto.setDateAcception(credit.getDateAcception());
        dto.setMontant(credit.getMontant());
        dto.setDureeRemboursement(credit.getDureeRemboursement());
        dto.setTauxInteret(credit.getTauxInteret());
        dto.setClientId(credit.getClient().getId());

        if (credit instanceof PersonalCredit) {
            dto.setType("Personal");
            dto.setMotif(((PersonalCredit) credit).getMotif());
        } else if (credit instanceof ImmobilierCredit) {
            dto.setType("Immobilier");
            dto.setTypeBien(((ImmobilierCredit) credit).getTypeBien());
        } else if (credit instanceof ProfessionnelCredit) {
            dto.setType("Professionnel");
            dto.setMotif(((ProfessionnelCredit) credit).getMotif());
            dto.setRaisonSociale(((ProfessionnelCredit) credit).getRaisonSociale());
        }
        return dto;
    }

    public Credit toEntity(CreditDTO dto, Client client) {
        Credit credit;
        if ("Personal".equals(dto.getType())) {
            PersonalCredit personal = new PersonalCredit();
            personal.setMotif(dto.getMotif());
            credit = personal;
        } else if ("Immobilier".equals(dto.getType())) {
            ImmobilierCredit immobilier = new ImmobilierCredit();
            immobilier.setTypeBien(dto.getTypeBien());
            credit = immobilier;
        } else {
            ProfessionnelCredit professionnel = new ProfessionnelCredit();
            professionnel.setMotif(dto.getMotif());
            professionnel.setRaisonSociale(dto.getRaisonSociale());
            credit = professionnel;
        }

        credit.setId(dto.getId());
        credit.setDateDemande(dto.getDateDemande());
        credit.setStatut(dto.getStatut());
        credit.setDateAcception(dto.getDateAcception());
        credit.setMontant(dto.getMontant());
        credit.setDureeRemboursement(dto.getDureeRemboursement());
        credit.setTauxInteret(dto.getTauxInteret());
        credit.setClient(client);

        return credit;
    }
}