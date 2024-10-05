package com.example.Health.ui.controllers;

import com.example.Health.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class MustacheTestController {
    @GetMapping("mustachetest")
    public String load(Model model){
        //variable
        model.addAttribute("variable","Hello variable");
        model.addAttribute("variable",123);

        //html_content
        model.addAttribute("html_content", "<p>Hello HTML </p>");

        //isAdmin
        //model.addAttribute("isAdmin",true);
        //model.addAttribute("isAdmin");
        //model.addAttribute("isAdmin",false);
       // model.addAttribute("isAdmin",123);
        //Inverted Section
        //model.addAttribute("isAdmin",true);
        //model.addAttribute("isAdmin");
        //model.addAttribute("isAdmin",false);
         model.addAttribute("isAdmin",123);
        //Cycle(List)
        //String[] list = new String []{"aaa", "bbb", "ccc"};
        //model.addAttribute("list",list);

        ArrayList<Patient> list = new ArrayList<>();
        list.add (new Patient(0,"As1","An1","Ap1", Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "111","a1@ukr.net"));
        list.add (new Patient(0,"As2","An2","Ap2", Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "222","a2@ukr.net"));
        list.add (new Patient(0,"As3","An3","Ap3", Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "333","a3@ukr.net"));

        model.addAttribute("list",list.get(0));
        //
        return "mustacheTest";
    }
}
