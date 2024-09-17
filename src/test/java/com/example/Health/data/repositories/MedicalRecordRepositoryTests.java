package com.example.Health.data.repositories;

import com.example.Health.models.MedicalRecord; //імпортує модель
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


public class MedicalRecordRepositoryTests {
    private static MedicalRecord mr1 = new MedicalRecord(0, Date.valueOf(LocalDate.now()), "Paracetamol 2 times a day",null);
    private static MedicalRecord mr2 = new MedicalRecord(0, Date.valueOf(LocalDate.now()), "Aspirin 2 times a day",null);

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;


    @Test
    @Order(1)
    public void saveAll() {
        MedicalRecord mr1_saved = medicalRecordRepository.save(mr1);
        MedicalRecord mr2_saved = medicalRecordRepository.save(mr2);
        mr1.setId(mr1_saved.getId());
        mr2.setId(mr2_saved.getId());
        Assertions.assertEquals(mr1, mr1_saved);
        Assertions.assertEquals(mr2, mr2_saved);
    }

    @Test
    @Order(2)
    public void findById() {
        Optional<MedicalRecord> mr1_container = medicalRecordRepository.findById(mr1.getId());
        if (mr1_container.isPresent()) {
            Assertions.assertEquals(mr1, mr1_container.get());
        } else {
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void findAll() {
        // Отримуємо всі записи з бази даних
        List<MedicalRecord> allRecord = medicalRecordRepository.findAll();

        // Перевіряємо, що отримано всі записи (має бути 2)
        Assertions.assertEquals(2, allRecord.size());

        // Виведемо список усіх докторів для відлагодження
        System.err.println("ALL : " + allRecord);
    }

    @Test
    @Order(4)
    public void update() {
        // Зберігаємо дані
        MedicalRecord mr2_saved = medicalRecordRepository.save(mr2);

        // Оновлюємо деякі поля пацієнта
        mr2_saved.setMedicalRecords("!!!!!GOOD!!!!!");

        // Зберігаємо оновленого пацієнта
        MedicalRecord mr2_update = medicalRecordRepository.save(mr2_saved);

        // Перевіряємо, чи оновлені дані коректно збережені
        Assertions.assertEquals("!!!!!GOOD!!!!!", mr2_update.getMedicalRecords());

        // Виводимо оновленого для відлагодження
        System.out.println(mr2_update);
    }

    //  Видалення по ID
    @Test
    @Order(5)
    public void deleteById() {
        medicalRecordRepository.deleteById(mr1.getId());

        Optional<MedicalRecord> deletedRecord = medicalRecordRepository.findById(mr1.getId());
        Assertions.assertTrue(deletedRecord.isEmpty(), "Medical record should be deleted.");
    }


    // Видалення всіх записів
    @Test
    @Order(6)
    public void deleteAll() {
        medicalRecordRepository.deleteAll();

        // List<MedicalRecord> allRecordsAfterDelete = medicalRecordRepository.findAll();
        //Assertions.assertTrue(allRecordsAfterDelete.isEmpty(), "All medical records should be deleted.");

        Assertions.assertEquals(0, medicalRecordRepository.findAll().size());

    }



}
