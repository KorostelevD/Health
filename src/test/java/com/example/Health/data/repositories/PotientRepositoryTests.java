package com.example.Health.data.repositories;

import com.example.Health.models.LabResult;
import com.example.Health.models.Patient;
import com.mysql.cj.xdevapi.Client;
import jakarta.transaction.Transactional;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //анотації номер метода
public class PotientRepositoryTests {
    private static Patient a = new Patient(0, "a", "a", "a",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net",null,null,null);
    private static Patient b = new Patient(0, "b", "b", "b",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net",null,null,null);

    @Autowired
    private PatientRepository patientRepository;

    @Test
    @Order(1)
    public void save(){
        //System.out.println(patientRepository);
        Patient a_saved = patientRepository.save(a);
        //System.out.println(a_saved);
        a.setId(a_saved.getId());
        Assertions.assertEquals(a, a_saved);
    }
    @Test
    @Order(2)
    public void  saveAll(){
        Patient a_saved = patientRepository.save(a);
        Patient b_saved = patientRepository.save(b);
        a.setId(a_saved.getId());
        b.setId(b_saved.getId());
        Assertions.assertEquals(a,a_saved);
        Assertions.assertEquals(b, b_saved);
    }

    @Test
    @Order(3)
    public void findById(){
        Optional<Patient> a_container = patientRepository.findById(a.getId());
        if (a_container.isPresent()) {
            Assertions.assertEquals(a, a_container.get());
        }
        else {
            Assertions.fail();
        }
    }

    @Test
    @Order(4)
    public void findAllByCount(){
        Assertions.assertEquals(    2, patientRepository.findAll().size());
    }

    @Test
    @Order(5)
    public void findByCollection(){
        List<Patient> original = List.of(a, b);
        List<Patient> saved = patientRepository.findAll();
        Assertions.assertIterableEquals(original, saved);
    }

  // @Test
    @Order(7)
    public void deleteAll(){
        patientRepository.deleteAll();
        Assertions.assertEquals(0,patientRepository.findAll().size());
    }

    @Test
    @Order(6)
    public void findAllBySurnameAndNameAndPatronymic(){
        Patient a_saved = patientRepository.save(a);
        List<Patient> actual = patientRepository.findAllBySurnameAndNameAndPatronymic(
                a_saved.getSurname(), a_saved.getName(), a_saved.getPatronymic()
        );
        System.out.println(actual);
        Assertions.assertNotEquals(0,actual.size());
        Assertions.assertEquals(a_saved, actual.getFirst());
    }

    @Test
    @Order(8)
    @Transactional //не закриває транзакцію, для стрима
    public void test(){
        List <Patient> patientList = patientRepository.findByEmail("aaa@aa.com");
        long count = patientRepository.countByGenderNot(Patient.Gender.NONE);
        System.out.println(count);
        Stream<Patient> stream = patientRepository.findByGenderNot(Patient.Gender.NONE);
        stream.forEach(System.out::println);

    }


}