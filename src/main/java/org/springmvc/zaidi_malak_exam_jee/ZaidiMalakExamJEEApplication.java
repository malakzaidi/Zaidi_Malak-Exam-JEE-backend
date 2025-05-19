package org.springmvc.zaidi_malak_exam_jee;

import org.springmvc.zaidi_malak_exam_jee.entities.Client;
import org.springmvc.zaidi_malak_exam_jee.entities.PersonalCredit;
import org.springmvc.zaidi_malak_exam_jee.entities.Remboursement;
import org.springmvc.zaidi_malak_exam_jee.repositories.ClientRepository;
import org.springmvc.zaidi_malak_exam_jee.repositories.CreditRepository;
import org.springmvc.zaidi_malak_exam_jee.repositories.RemboursementRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootApplication
public class ZaidiMalakExamJEEApplication {

    public static void main(String[] args) {
        // Démarrer l'application et obtenir le contexte
        ApplicationContext context = SpringApplication.run(ZaidiMalakExamJEEApplication.class, args);
        // Récupérer les beans des repositories
        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        CreditRepository creditRepository = context.getBean(CreditRepository.class);
        RemboursementRepository remboursementRepository = context.getBean(RemboursementRepository.class);
        // Premier flux de données
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
        System.out.println("Database initialized with first sample data.");

        // Deuxième flux de données avec Stream.of
        Stream.of(new Client()).forEach(c -> {
            c.setNom("Jane Smith");
            c.setEmail("jane.smith@example.com");
            clientRepository.save(c);

            PersonalCredit credit = new PersonalCredit();
            credit.setClient(c);
            credit.setDateDemande(LocalDate.now().minusDays(10));
            credit.setStatut("Accepté");
            credit.setMontant(10000.0);
            credit.setDureeRemboursement(24);
            credit.setTauxInteret(4.5);
            credit.setMotif("Travaux de rénovation");
            creditRepository.save(credit);

            Remboursement remb = new Remboursement();
            remb.setCredit(credit);
            remb.setDate(LocalDate.now());
            remb.setMontant(450.0);
            remb.setType("Mensualité");
            remboursementRepository.save(remb);
        });

        System.out.println("Database initialized with second sample data using Stream.");
    }
}