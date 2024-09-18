package com.example.Health.data.services.db;

import com.example.Health.data.services.PatientService;
import com.example.Health.models.Patient;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientServiceDbTests {

    private static Patient a = new Patient(0, "a", "a", "a",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net");
    private static Patient b = new Patient(0, "b", "b", "b",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net");

    @Autowired
    PatientService patientService;

    @Test
    @Order(1)
    public void save(){
        Patient aSaved = patientService.save(a);
        a.setId(aSaved.getId());
        Assertions.assertEquals(a,aSaved);
        a=aSaved;
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Patient> optional = patientService.findById(a.getId());
         optional.ifPresentOrElse(patient -> {
             Assertions.assertEquals(a,patient);
         },()->{
             Assertions.fail("No patient");
                 }
         );
    }


}
