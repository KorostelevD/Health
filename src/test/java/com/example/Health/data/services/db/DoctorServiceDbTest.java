package com.example.Health.data.services.db;


import com.example.Health.data.services.DoctorService;
import com.example.Health.models.Doctor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class DoctorServiceDbTest {
    private static Doctor doctor1 = new Doctor(0, "therapist", "Oleg", "Petrenko","050 222 00");
    private static Doctor doctor2 = new Doctor(0, "surgeon", "Ivan", "Lypko","050 222 22 22");

    @Autowired
    DoctorService doctorService;

    @Test
    @Order(1)
    public void save(){
        Doctor aSaved = doctorService.save(doctor1);
        doctor1.setId(aSaved.getId());
        Assertions.assertEquals(doctor1,aSaved);
        doctor1 = aSaved;
    }

    @Test
    @Order(2)
    public void findById(){
        Optional <Doctor> optional = doctorService.findById(doctor1.getId());
        optional.ifPresentOrElse(doctor ->
            Assertions.assertEquals(doctor1, doctor),
        () -> Assertions.fail("No doctor")
        );
    }
}
