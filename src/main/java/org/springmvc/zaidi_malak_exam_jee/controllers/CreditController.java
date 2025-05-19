package org.springmvc.zaidi_malak_exam_jee.controllers;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springmvc.zaidi_malak_exam_jee.dtos.CreditDTO;
import org.springmvc.zaidi_malak_exam_jee.services.CreditService;
import java.util.List;
@RestController
@RequestMapping("/api/credits")
public class CreditController {
    private final CreditService creditService;
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }
    @PostMapping
    @Operation(summary = "Créer un nouveau crédit")
    public ResponseEntity<CreditDTO> createCredit(@RequestBody CreditDTO creditDTO) {
        CreditDTO createdCredit = creditService.createCredit(creditDTO);
        return ResponseEntity.ok(createdCredit);
    }

    @GetMapping("/client/{clientId}")
    @Operation(summary = "Récupérer les crédits d'un client")
    public ResponseEntity<List<CreditDTO>> getCreditsByClient(@PathVariable Long clientId) {
        List<CreditDTO> credits = creditService.getCreditsByClient(clientId);
        return ResponseEntity.ok(credits);
    }

    @PutMapping("/{creditId}/status")
    @Operation(summary = "Mettre à jour le statut d'un crédit")
    public ResponseEntity<CreditDTO> updateCreditStatus(@PathVariable Long creditId, @RequestBody String status) {
        CreditDTO updatedCredit = creditService.updateCreditStatus(creditId, status);
        return ResponseEntity.ok(updatedCredit);
    }
}