package com.example.Health.data.repositories;

import com.example.Health.models.Patient;
import com.mysql.cj.xdevapi.Client;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //анотації номер метода
public class PotientRepositoryTests {
    private static Patient a = new Patient(0, "a", "a", "a",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net");
    private static Patient b = new Patient(0, "b", "b", "b",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net");

    @Autowired
    private PatientRepository patientRepository;

   // @Test
    public void save(){
        //System.out.println(patientRepository);
        Patient a_saved = patientRepository.save(a);
        //System.out.println(a_saved);
        a.setId(a_saved.getId());
        Assertions.assertEquals(a, a_saved);
    }
    @Test
    @Order(1)
    public void  saveAll(){
        Patient a_saved = patientRepository.save(a);
        Patient b_saved = patientRepository.save(b);
        a.setId(a_saved.getId());
        b.setId(b_saved.getId());
        Assertions.assertEquals(a,a_saved);
        Assertions.assertEquals(b, b_saved);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Patient> a_container = patientRepository.findById(a.getId());
        if (a_find.isPresent()) {
            Assertions.assertEquals(a, a_find.get());
        }
        else {
            Assertions.fail();
        }
    }
}