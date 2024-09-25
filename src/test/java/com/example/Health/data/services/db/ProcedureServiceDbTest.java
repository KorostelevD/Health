package com.example.Health.data.services.db;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.ProcedureService;
import com.example.Health.models.Patient;
import com.example.Health.models.Procedure;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ProcedureServiceDbTest {
    // Створюємо новий об'єкт пацієнта (пацієнт не може бути null)
    private static Patient patient1 = new Patient(0, "a", "a", "a",
            Patient.Gender.MALE, Date.valueOf(LocalDate.now()), "00000000", "m@ukr.net");

    private static Procedure procedure1 = new Procedure(0, Date.valueOf(LocalDate.now()),"Physiotherapy procedures",patient1);
    private static Procedure procedure2 = new Procedure(0, Date.valueOf(LocalDate.now()),"Therapeutic exercise",patient1 );

    @Autowired
    private ProcedureService procedureService;

    @Autowired
    private PatientService patientService;  // Сервіс для збереження пацієнтів


    @Test
    @Order(1)
    public void save(){
        Patient savedPatient = patientService.save(patient1);
        patient1.setId(savedPatient.getId());  // Оновлюємо ID пацієнта після збереження

        // Тепер прив'язуємо пацієнта до процедури
        procedure1.setPatient(savedPatient);

        Procedure aSaved = procedureService.save(procedure1);
        procedure1.setId(aSaved.getId());
        Assertions.assertEquals(procedure1, aSaved);
        procedure1 = aSaved;
    }



}
