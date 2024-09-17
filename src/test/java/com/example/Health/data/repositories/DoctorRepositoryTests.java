package com.example.Health.data.repositories;

import com.example.Health.models.Doctor; //імпортує модель Doctor
//біблиотеки для тестування

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest //запускає контекст Spring для виконання тестів у середовищі Spring Boot.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //вказує, що тести будуть виконуватися в порядку, визначеному анотацією @Order

public class DoctorRepositoryTests {
    private static Doctor doctor1 = new Doctor(0, "therapist", "Oleg", "Petrenko","050 111 11 11",null);
    private static Doctor doctor2 = new Doctor(0, "surgeon", "Ivan", "Lypko","050 222 22 22",null);

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    @Order(1)
    public void save(){
        Doctor doctor1_saved = doctorRepository.save(doctor1);
        doctor1.setId((doctor1_saved.getId()));
        Assertions.assertEquals(doctor1,doctor1_saved);
        System.err.println(doctor1_saved);
    }

    @Test
    @Order(2)
    public void  saveAll(){
        Doctor doctor1_saved = doctorRepository.save(doctor1);
        Doctor doctor2_saved = doctorRepository.save(doctor2);
        doctor1.setId(doctor1_saved.getId());
        doctor2.setId(doctor2_saved.getId());
        Assertions.assertEquals(doctor1,doctor1_saved);
        Assertions.assertEquals(doctor2, doctor2_saved);
        System.err.println(doctor1_saved);
        System.err.println(doctor2_saved);
    }

    @Test
    @Order(3)
    public void findById() {
        Optional<Doctor> doctor_container = doctorRepository.findById(doctor1.getId());
        if (doctor_container.isPresent()) {
            Assertions.assertEquals(doctor1, doctor_container.get());
        } else {
            Assertions.fail();
        }
    }

    @Test
    @Order(4)
    public void findAll(){
        // Отримуємо всі записи з бази даних
        List<Doctor> allDoctors = doctorRepository.findAll();

        // Перевіряємо, що отримано всі записи (має бути 2 пацієнти)
        Assertions.assertEquals(2, allDoctors.size());

        // Виведемо список усіх докторів для відлагодження
        System.err.println("ALL : " + allDoctors);
    }
    @Test
    @Order(5)
    public void update(){
        // Зберігаємо дані
        Doctor doctor1_saved = doctorRepository.save(doctor1);
        Doctor doctor2_saved = doctorRepository.save(doctor2);

        // Оновлюємо деякі поля пацієнта
        doctor1_saved.setName("Pavlo");
        doctor2_saved.setContact("099 333 33 33");

        // Зберігаємо оновленого пацієнта
        Doctor doctor1_update = doctorRepository.save(doctor1_saved);
        Doctor doctor2_update = doctorRepository.save(doctor2_saved);

        // Перевіряємо, чи оновлені дані коректно збережені
        Assertions.assertEquals("Pavlo", doctor1_update.getName());
        Assertions.assertEquals("099 333 33 33", doctor2_update.getContact());

        // Виводимо оновленого для відлагодження
        System.out.println(doctor1_update);
        System.out.println(doctor2_update);
    }

    @Test
    @Order(6)
    public void deleteAll() {
        doctorRepository.deleteAll();
        Assertions.assertEquals(0, doctorRepository.findAll().size());
    }
}
