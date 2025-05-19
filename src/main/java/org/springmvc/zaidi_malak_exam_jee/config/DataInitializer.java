package org.springmvc.zaidi_malak_exam_jee.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springmvc.zaidi_malak_exam_jee.entities.Client;
import org.springmvc.zaidi_malak_exam_jee.entities.PersonalCredit;
import org.springmvc.zaidi_malak_exam_jee.entities.Remboursement;
import org.springmvc.zaidi_malak_exam_jee.repositories.ClientRepository;
import org.springmvc.zaidi_malak_exam_jee.repositories.CreditRepository;
import org.springmvc.zaidi_malak_exam_jee.repositories.RemboursementRepository;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository,
                                   CreditRepository creditRepository,
                                   RemboursementRepository remboursementRepository) {
        return args -> {
            Client client = new Client();
            client.setNom("John Doe");
            client.setEmail("john.doe@example.com");
            clientRepository.save(client);

            PersonalCredit personalCredit = new PersonalCredit();
            personalCredit.setClient(client);
            personalCredit.setDateDemande(LocalDate.now());
            personalCredit.setStatut("En cours");
            personalCredit.setMontant(5000.0);
            personalCredit.setDureeRemboursement(12);
            personalCredit.setTauxInteret(5.0);
            personalCredit.setMotif("Achat de voiture");
            creditRepository.save(personalCredit);

            Remboursement remboursement = new Remboursement();
            remboursement.setCredit(personalCredit);
            remboursement.setDate(LocalDate.now());
            remboursement.setMontant(500.0);
            remboursement.setType("Mensualité");
            remboursementRepository.save(remboursement);

            System.out.println("Database initialized with sample data.");
        };
    }
}