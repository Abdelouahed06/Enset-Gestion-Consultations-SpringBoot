package com.example.consultationmanagement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.consultationmanagement.model.Consultation;
import com.example.consultationmanagement.service.ConsultationService;

@Controller
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    // View all consultations
    @GetMapping("/consultations")
    public String getAllConsultations(Model model) {
        model.addAttribute("consultations", consultationService.getAllConsultations());
        return "consultations";
    }

    // View consultation details
    @GetMapping("/consultations/{id}")
    public String getConsultationDetails(@PathVariable Long id, Model model) {
        Optional<Consultation> consultation = consultationService.getConsultationById(id);
        consultation.ifPresent(value -> model.addAttribute("consultation", value));
        return "consultation-details";
    }

    // Show edit consultation form
    @GetMapping("/consultations/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Consultation> consultation = consultationService.getConsultationById(id);
        consultation.ifPresent(value -> model.addAttribute("consultation", value));
        return "edit-consultation";
    }

    // Update consultation
    @PostMapping("/consultations/update/{id}")
    public String updateConsultation(@PathVariable Long id, @ModelAttribute Consultation consultation) {
        consultation.setId(id);
        consultationService.saveConsultation(consultation);
        return "redirect:/consultations";
    }

    // Delete consultation
    @GetMapping("/consultations/delete/{id}")
    public String deleteConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
        return "redirect:/consultations";
    }

    // Add new consultation
    @PostMapping("/consultations")
    public String addConsultation(@ModelAttribute Consultation consultation) {
        consultationService.saveConsultation(consultation);
        return "redirect:/consultations";
    }
}