package com.example.Health.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //http://localhost:8080 - пусті лапки "" або "/"

        registry.addViewController("/").setViewName("/patients");

        http://localhost:8080/error
        registry.addViewController("/error").setViewName("/error"); //clients - file name


    }
}
