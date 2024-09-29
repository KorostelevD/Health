package com.example.Health.models;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Configuration
public class PhoneGenerator {
@Bean
    public ArrayList<Procedure> procedureList(){
    ArrayList<Procedure> list = new ArrayList<>();
    list.add(new Procedure(0, Date.valueOf(LocalDate.now()),"Physiotherapy procedures"));
    list.add(new Procedure(0, Date.valueOf(LocalDate.now()),"2Physiotherapy procedures"));
    list.add(new Procedure(0, Date.valueOf(LocalDate.now()),"3Physiotherapy procedures"));
    list.add(new Procedure(0, Date.valueOf(LocalDate.now()),"4Physiotherapy procedures"));
    list.add(new Procedure(0, Date.valueOf(LocalDate.now()),"5Physiotherapy procedures"));
    return list;
    }
}
