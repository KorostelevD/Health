package com.example.Health.data.services.db;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.qualifiers.PatientServiceDbQualifier;
import com.example.Health.data.services.qualifiers.PatientServiceQualifier;
import com.example.Health.models.Patient;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientServiceDbTests {

    //Генертор!
    @Autowired
    Patient a;

    @Autowired
    //@Qualifier(value = "patientServiceDb") // з малої букви об'єкт
    //@Qualifier("patientServiceDb") // з малої букви об'єкт
    //@PatientServiceQualifier
    @PatientServiceDbQualifier
    PatientService patientService; //интерфейс сервісу

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
         optional.ifPresentOrElse(
                 patient -> Assertions.assertEquals(a,patient),
         ()-> Assertions.fail("No patient")
         );
    }


}
