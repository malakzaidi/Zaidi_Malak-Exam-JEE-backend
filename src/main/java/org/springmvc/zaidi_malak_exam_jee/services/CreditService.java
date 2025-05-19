package org.springmvc.zaidi_malak_exam_jee.services;

import org.springmvc.zaidi_malak_exam_jee.dtos.CreditDTO;

import java.util.List;

public interface CreditService {
    CreditDTO createCredit(CreditDTO creditDTO);
    List<CreditDTO> getCreditsByClient(Long clientId);
    CreditDTO updateCreditStatus(Long creditId, String status);
}