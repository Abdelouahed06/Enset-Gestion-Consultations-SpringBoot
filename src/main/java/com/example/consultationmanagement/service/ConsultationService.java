package com.example.consultationmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.consultationmanagement.model.Consultation;
import com.example.consultationmanagement.repository.ConsultationRepository;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepository consultationRepository;

    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    public Optional<Consultation> getConsultationById(Long id) {
        return consultationRepository.findById(id);
    }

    public void deleteConsultation(Long id) {
        consultationRepository.deleteById(id);
    }
}