package com.example.consultationmanagement.controller;

import com.example.consultationmanagement.model.Consultation;
import com.example.consultationmanagement.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @GetMapping("/consultations")
    public String getAllConsultations(Model model) {
        model.addAttribute("consultations", consultationService.getAllConsultations());
        return "consultations"; // Thymeleaf template name
    }

    @PostMapping("/consultations")
    public String addConsultation(@ModelAttribute Consultation consultation) {
        consultationService.saveConsultation(consultation);
        return "redirect:/consultations";
    }
}