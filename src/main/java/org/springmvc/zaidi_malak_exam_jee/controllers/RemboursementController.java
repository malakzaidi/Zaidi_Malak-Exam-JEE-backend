package org.springmvc.zaidi_malak_exam_jee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springmvc.zaidi_malak_exam_jee.dtos.RemboursementDTO;
import org.springmvc.zaidi_malak_exam_jee.entities.Credit;
import org.springmvc.zaidi_malak_exam_jee.entities.Remboursement;
import org.springmvc.zaidi_malak_exam_jee.mapper.RemboursementMapper;
import org.springmvc.zaidi_malak_exam_jee.repositories.CreditRepository;
import org.springmvc.zaidi_malak_exam_jee.repositories.RemboursementRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/credits/{creditId}/remboursements")
public class RemboursementController {

    private final RemboursementRepository remboursementRepository;
    private final CreditRepository creditRepository;
    private final RemboursementMapper remboursementMapper;

    public RemboursementController(RemboursementRepository remboursementRepository,
                                   CreditRepository creditRepository,
                                   RemboursementMapper remboursementMapper) {
        this.remboursementRepository = remboursementRepository;
        this.creditRepository = creditRepository;
        this.remboursementMapper = remboursementMapper;
    }

    @PostMapping
    @Operation(summary = "Ajouter un remboursement à un crédit")
    public ResponseEntity<RemboursementDTO> createRemboursement(@PathVariable Long creditId,
                                                                @RequestBody RemboursementDTO remboursementDTO) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        Remboursement remboursement = remboursementMapper.toEntity(remboursementDTO, credit);
        Remboursement savedRemboursement = remboursementRepository.save(remboursement);
        return ResponseEntity.ok(remboursementMapper.toDTO(savedRemboursement));
    }

    @GetMapping
    @Operation(summary = "Lister les remboursements d'un crédit")
    public ResponseEntity<List<RemboursementDTO>> getRemboursementsByCredit(@PathVariable Long creditId) {
        List<RemboursementDTO> remboursements = remboursementRepository.findAll().stream()
                .filter(r -> r.getCredit().getId().equals(creditId))
                .map(remboursementMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(remboursements);
    }
}