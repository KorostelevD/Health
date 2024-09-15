package com.example.Health.data.repositories;

import com.example.Health.models.MedicalRecord;
import com.example.Health.models.Procedure; //імпортує модель
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

public class ProcedureRepositoryTests {
    private static Procedure procedure1 = new Procedure(0, Date.valueOf(LocalDate.now()),"Physiotherapy procedures" );
    private static Procedure procedure2 = new Procedure(0, Date.valueOf(LocalDate.now()),"Therapeutic exercise" );

    @Autowired
    private ProcedureRepository procedureRepository;

    @Test
    @Order(1)
    public void saveAll() {
        Procedure procedure1_saved = procedureRepository.save(procedure1);
        Procedure procedure2_saved = procedureRepository.save(procedure2);
        procedure1.setId(procedure1_saved.getId());
        procedure2.setId(procedure2_saved.getId());
        Assertions.assertEquals(procedure1, procedure1_saved);
        Assertions.assertEquals(procedure2, procedure2_saved);
    }

    @Test
    @Order(2)
    public void findById() {
        Optional<Procedure> procedure1_container = procedureRepository.findById(procedure1.getId());
        if (procedure1_container.isPresent()) {
            Assertions.assertEquals(procedure1, procedure1_container.get());
            System.err.println(procedure1_container);
        } else {
            Assertions.fail();
        }

    }
    @Test
    @Order(3)
    public void findAll() {
        // Отримуємо всі записи з бази даних
        List<Procedure> allProcedure = procedureRepository.findAll();

        // Перевіряємо, що отримано всі записи (має бути 2)
        Assertions.assertEquals(2, allProcedure.size());

        // Виведемо список усіх докторів для відлагодження
        System.err.println("ALL : " + allProcedure);
    }

    @Test
    @Order(4)
    public void update() {
        // Зберігаємо дані
        Procedure procedure2_saved = procedureRepository.save(procedure2);

        // Оновлюємо деякі поля пацієнта
        procedure2_saved.setProcedures("!!!WATER!!!");

        // Зберігаємо оновленого пацієнта
        Procedure procedure2_update = procedureRepository.save(procedure2_saved);

        // Перевіряємо, чи оновлені дані коректно збережені
        Assertions.assertEquals("!!!WATER!!!", procedure2_update.getProcedures());

        // Виводимо оновленого для відлагодження
        System.err.println(procedure2_update);
    }

    //  Видалення по ID
    @Test
    @Order(5)
    public void deleteById() {
        procedureRepository.deleteById(procedure2.getId());

        Optional<Procedure> deletedProcedure = procedureRepository.findById(procedure2.getId());
        Assertions.assertTrue(deletedProcedure.isEmpty(), "Medical record should be deleted.");
    }


    // Видалення всіх записів
    @Test
    @Order(6)
    public void deleteAll() {
        procedureRepository.deleteAll();
        Assertions.assertEquals(0, procedureRepository.findAll().size());
    }

}
