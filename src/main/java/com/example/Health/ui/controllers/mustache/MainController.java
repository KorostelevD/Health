package com.example.Health.ui.controllers.mustache;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String load(){
        return "redirect:mustache/patients";
    }

}
