package org.springmvc.zaidi_malak_exam_jee.controllers;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springmvc.zaidi_malak_exam_jee.dtos.ClientDTO;
import org.springmvc.zaidi_malak_exam_jee.entities.Client;
import org.springmvc.zaidi_malak_exam_jee.mapper.ClientMapper;
import org.springmvc.zaidi_malak_exam_jee.repositories.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientController(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau client")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client savedClient = clientRepository.save(client);
        return ResponseEntity.ok(clientMapper.toDTO(savedClient));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client par ID")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return ResponseEntity.ok(clientMapper.toDTO(client));
    }

    @GetMapping
    @Operation(summary = "Lister tous les clients")
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(clients);
    }
}