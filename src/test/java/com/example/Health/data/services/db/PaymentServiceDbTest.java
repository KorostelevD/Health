package com.example.Health.data.services.db;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.PaymentService;
import com.example.Health.models.Payment;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class PaymentServiceDbTest {
    private static Payment pm1 = new Payment(0, Date.valueOf(LocalDate.now()),true);
    private static Payment pm2 = new Payment(0, Date.valueOf(LocalDate.now()),false);

    @Autowired
    PaymentService paymentService;

    @Test
    @Order(1)
    public void save(){
        Payment aSaved = paymentService.save(pm1);
        pm1.setId(aSaved.getId());
        Assertions.assertEquals(pm1,aSaved);
        pm1 = aSaved;
    }

    @Test
    @Order(2)
    public void findById(){
        Optional<Payment> optional = paymentService.findById(pm1.getId());
        optional.ifPresentOrElse(
                payment -> Assertions.assertEquals(pm1,payment),
                () -> Assertions.fail("No Payment")
        );
    }





}
