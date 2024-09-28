package com.example.Health.data.services.json;

import com.example.Health.models.Patient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientServiceJsonTest {

    @Autowired
    ArrayList<Patient> patientList;

    @Test
    @Order(1)
    public void get(){
        System.err.println(patientList);
    }



}
