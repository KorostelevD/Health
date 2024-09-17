package com.example.Health.data.repositories;

import com.example.Health.models.Payment; //імпортує модель
//біблиотеки для тестування

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest //запускає контекст Spring для виконання тестів у середовищі Spring Boot.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //вказує, що тести будуть виконуватися в порядку, визначеному анотацією @Order



public class PaymentRepositoryTests {
    private static Payment pm1 = new Payment(0, Date.valueOf(LocalDate.now()),true, null);
    private static Payment pm2 = new Payment(0, Date.valueOf(LocalDate.now()),true,null);

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    @Order(1)
    public void saveAll() {
        Payment pm1_saved = paymentRepository.save(pm1);
        Payment pm2_saved = paymentRepository.save(pm2);
        pm1.setId(pm1_saved.getId());
        pm2.setId(pm2_saved.getId());
        Assertions.assertEquals(pm1, pm1_saved);
        Assertions.assertEquals(pm2, pm2_saved);
    }


    @Test
    @Order(2)
    public void findById() {
        Optional<Payment> pm1_container = paymentRepository.findById(pm1.getId());
        if (pm1_container.isPresent()) {
            Assertions.assertEquals(pm1, pm1_container.get());
            System.err.println(pm1_container);
        } else {
            Assertions.fail();
        }
    }


    @Test
    @Order(3)
    public void findAll() {
        // Отримуємо всі записи з бази даних
        List<Payment> allPayment = paymentRepository.findAll();

        // Перевіряємо, що отримано всі записи (має бути 2)
        Assertions.assertEquals(2, allPayment.size());

        // Виведемо список усіх докторів для відлагодження
        System.err.println("ALL : " + allPayment);
    }

    @Test
    @Order(4)
    public void update() {
        // Зберігаємо дані
        Payment pm2_saved = paymentRepository.save(pm2);

        // Оновлюємо поля
        pm2_saved.setPayment(false);

        // Зберігаємо поля
        Payment pm2_update = paymentRepository.save(pm2_saved);

        // Виводимо оновленого для відлагодження
        System.out.println(pm2_update);
    }

    //Видалення по ID
    @Test
    @Order(5)
    public void deleteById() {
        paymentRepository.deleteById(pm1.getId());

        Optional<Payment> deletedPayment = paymentRepository.findById(pm1.getId());
        Assertions.assertTrue(deletedPayment.isEmpty(), "Medical record should be deleted.");
    }

    // Видалення всіх записів
    @Test
    @Order(6)
    public void deleteAll() {
        paymentRepository.deleteAll();
        Assertions.assertEquals(0, paymentRepository.findAll().size());
    }


}
