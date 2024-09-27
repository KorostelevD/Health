package com.example.Health.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//////////////
@Configuration
public class PatientGenerator {
@Bean
    public Patient patient(){
    return new Patient(
            0,
            "As",
            "An",
            "Ap",
            Patient.Gender.MALE,
            Date.valueOf(LocalDate.now()),
            "1111111111",
            "uuu@ukr.net"
    );
}

@Bean
    public List<Patient> patientList(){
    return List.of(
            new Patient(0,"As1","An1","Ap1", Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "111","a1@ukr.net"),
            new Patient(0,"As2","An2","Ap2", Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "222","a2@ukr.net"),
            new Patient(0,"As3","An3","Ap3", Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "333","a3@ukr.net")
    );
    }
}
