package com.example.Health.ui.controllers;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.ProcedureService;
import com.example.Health.data.services.qualifiers.PatientServiceDbQualifier;
import com.example.Health.models.Patient;
import com.example.Health.models.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PatientUpdateController {

    @Autowired
    @PatientServiceDbQualifier
    PatientService patientService;
    @Autowired
    ProcedureService procedureService;

    @GetMapping("/patientupdate")
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

    @PostMapping("/addProcedureForm")
    public ModelAndView addProcedureForm(@RequestParam ("patientId") Integer patientId, @ModelAttribute Procedure procedure){
        System.err.println(patientId);
        System.err.println(procedure);
        //
        Optional<Patient> optionalPatient = patientService.findById(patientId);
        if (optionalPatient.isPresent()){
            Patient patient = optionalPatient.get();
            procedure = procedureService.save(procedure);
            procedure.setPatient(patient);
            procedureService.save(procedure);
        }
        return new ModelAndView(
                "redirect:/patientupdate",
                new ModelMap("patientId", patientId)
        );
    }
}
