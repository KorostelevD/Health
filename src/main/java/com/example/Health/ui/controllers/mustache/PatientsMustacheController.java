package com.example.Health.ui.controllers.mustache;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.qualifiers.PatientServiceDbQualifier;
import com.example.Health.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class PatientsMustacheController {

    @Autowired
    @PatientServiceDbQualifier
    PatientService patientService;



  /*  @GetMapping("/")
    //@RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}, path = "/")
    public String load(){
        return "redirect:patients";
    }*/

    @GetMapping("mustache/patients")
    public String loadPatients(Model model) {
        List<Patient> list = patientService.findAll();
        model.addAttribute("patients", list);
        return "mustache/patients";
    }


    //@PostMapping("patientFormMustache")
    public String patientForm1(

            @RequestParam("surname") String surname,
            @RequestParam("name") String name,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("gender") Patient.Gender gender,
            @RequestParam("birthDate") Date birthDate,
            @RequestParam("phonenumber") String phonenumber,
            @RequestParam("email") String email
    ){
        Patient patient = new Patient(0, surname, name, patronymic,gender, birthDate,phonenumber, email);
        System.err.println(patient);
        return "redirect:patients";
    }

    @PostMapping("patientFormMustache")
    public String patientForm2(@ModelAttribute("patient") Patient patient){
        System.err.println(patient);
        patientService.save(patient);
        return "redirect:patients";
    }
}
