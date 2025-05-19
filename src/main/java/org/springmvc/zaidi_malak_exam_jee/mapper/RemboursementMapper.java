package org.springmvc.zaidi_malak_exam_jee.mapper;


import org.springmvc.zaidi_malak_exam_jee.dtos.RemboursementDTO;
import org.springmvc.zaidi_malak_exam_jee.entities.Remboursement;
import org.springmvc.zaidi_malak_exam_jee.entities.Credit;
import org.springframework.stereotype.Component;

@Component
public class RemboursementMapper {

    public RemboursementDTO toDTO(Remboursement remboursement) {
        RemboursementDTO dto = new RemboursementDTO();
        dto.setId(remboursement.getId());
        dto.setDate(remboursement.getDate());
        dto.setMontant(remboursement.getMontant());
        dto.setType(remboursement.getType());
        dto.setCreditId(remboursement.getCredit().getId());
        return dto;
    }

    public Remboursement toEntity(RemboursementDTO dto, Credit credit) {
        Remboursement remboursement = new Remboursement();
        remboursement.setId(dto.getId());
        remboursement.setDate(dto.getDate());
        remboursement.setMontant(dto.getMontant());
        remboursement.setType(dto.getType());
        remboursement.setCredit(credit);
        return remboursement;
    }
}