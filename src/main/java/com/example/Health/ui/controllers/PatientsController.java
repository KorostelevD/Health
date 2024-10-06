package com.example.Health.ui.controllers;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.qualifiers.PatientServiceDbQualifier;
import com.example.Health.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientsController {
    @Autowired
    @PatientServiceDbQualifier
    PatientService patientService;

    @GetMapping("patients")
    public String load(Model model){
        List<Patient> list = patientService.findAll();
        model.addAttribute("patientList",list);
        return "patients";
    }

    @PostMapping("addPatientForm")
    public String addPatientForm (@ModelAttribute Patient patient){
        patientService.save(patient);
        return "redirect:patients";
    }
}
