package org.springmvc.zaidi_malak_exam_jee.services;



import org.springframework.stereotype.Service;
import org.springmvc.zaidi_malak_exam_jee.dtos.CreditDTO;
import org.springmvc.zaidi_malak_exam_jee.entities.Client;
import org.springmvc.zaidi_malak_exam_jee.entities.Credit;
import org.springmvc.zaidi_malak_exam_jee.mapper.CreditMapper;
import org.springmvc.zaidi_malak_exam_jee.repositories.ClientRepository;
import org.springmvc.zaidi_malak_exam_jee.repositories.CreditRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
    private final ClientRepository clientRepository;
    private final CreditMapper creditMapper;

    public CreditServiceImpl(CreditRepository creditRepository, ClientRepository clientRepository, CreditMapper creditMapper) {
        this.creditRepository = creditRepository;
        this.clientRepository = clientRepository;
        this.creditMapper = creditMapper;
    }

    @Override
    public CreditDTO createCredit(CreditDTO creditDTO) {
        Client client = clientRepository.findById(creditDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        Credit credit = creditMapper.toEntity(creditDTO, client);
        Credit savedCredit = creditRepository.save(credit);
        return creditMapper.toDTO(savedCredit);
    }

    @Override
    public List<CreditDTO> getCreditsByClient(Long clientId) {
        List<Credit> credits = creditRepository.findAll().stream()
                .filter(credit -> credit.getClient().getId().equals(clientId))
                .collect(Collectors.toList());
        return credits.stream().map(creditMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CreditDTO updateCreditStatus(Long creditId, String status) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        credit.setStatut(status);
        Credit updatedCredit = creditRepository.save(credit);
        return creditMapper.toDTO(updatedCredit);
    }
}