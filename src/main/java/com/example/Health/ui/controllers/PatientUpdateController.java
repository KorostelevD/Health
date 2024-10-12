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

import java.util.Optional;

@Controller
public class PatientUpdateController {

    @Autowired
    @PatientServiceDbQualifier
    PatientService patientService;

    @GetMapping("patientupdate")
    public String load(Model model, @RequestParam ("patientId") Integer patientId ){//що приходить и уходить
        Optional < Patient> optionalPatient = patientService.findById(patientId);
        if (optionalPatient.isPresent()){ //якщо клієнт приходить
            model.addAttribute("patient", optionalPatient.get());
            return "patientUpdate";
        }
        return "patientUpdate"; //заклушка

    }

    @PostMapping("patientUpdateForm")
    public String patientUpdateForm (@ModelAttribute Patient patient){
        patientService.save(patient);
        return "redirect:patients";
    }



}
