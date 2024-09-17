package com.example.Health.data.repositories;

import com.example.Health.models.LabResult; //імпортує модель
//біблиотеки для тестування

import lombok.Data;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest //запускає контекст Spring для виконання тестів у середовищі Spring Boot.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //вказує, що тести будуть виконуватися в порядку, визначеному анотацією @Order


public class LabResultRepositoryTests {
    private static LabResult res1 = new LabResult(0, Date.valueOf(LocalDate.now()),"good anslysis",null);
    private static LabResult res2 = new LabResult(0, Date.valueOf(LocalDate.now()),"bed anslysis",null);

    @Autowired
    private LabResultRepository labResultRepository;


    @Test
    @Order(1)
    public void  saveAll() {
        LabResult res1_saved = labResultRepository.save(res1);
        LabResult res2_saved = labResultRepository.save(res2);
        res1.setId(res1_saved.getId());
        res2.setId(res2_saved.getId());
        Assertions.assertEquals(res1, res1_saved);
        Assertions.assertEquals(res2, res2_saved);
    }

    @Test
    @Order(2)
    public void findById(){
        Optional <LabResult> res1_container = labResultRepository.findById(res1.getId());
        if (res1_container.isPresent()) {
            Assertions.assertEquals(res1, res1_container.get());
        }
        else {
            Assertions.fail();
        }
    }

    @Test
    @Order(3)
    public void findAll(){
        // Отримуємо всі записи з бази даних
        List<LabResult> allResult = labResultRepository.findAll();

        // Перевіряємо, що отримано всі записи (має бути 2)
        Assertions.assertEquals(2, allResult.size());

        // Виведемо список усіх докторів для відлагодження
        System.err.println("ALL : " + allResult);
    }

    @Test
    @Order(4)
    public void update(){
        // Зберігаємо дані
        LabResult res2_saved = labResultRepository.save(res2);


        // Оновлюємо деякі поля пацієнта
        res2_saved.setResult("GOOD!!!");

        // Зберігаємо оновленого пацієнта
        LabResult res2_update = labResultRepository.save(res2_saved);

        // Перевіряємо, чи оновлені дані коректно збережені
        Assertions.assertEquals("GOOD!!!", res2_update.getResult());

        // Виводимо оновленого для відлагодження
        System.out.println(res2_update);
    }

    @Test
    @Order(5)
    public void deleteAll() {
        labResultRepository.deleteAll();
        Assertions.assertEquals(0, labResultRepository.findAll().size());
    }

}
