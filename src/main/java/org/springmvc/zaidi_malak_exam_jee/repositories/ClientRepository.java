package org.springmvc.zaidi_malak_exam_jee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springmvc.zaidi_malak_exam_jee.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}