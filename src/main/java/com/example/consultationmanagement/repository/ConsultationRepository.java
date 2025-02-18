package com.example.consultationmanagement.repository;

import com.example.consultationmanagement.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}