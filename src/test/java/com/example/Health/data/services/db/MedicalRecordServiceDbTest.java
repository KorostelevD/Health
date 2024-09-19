package com.example.Health.data.services.db;

import com.example.Health.data.services.LabResultService;
import com.example.Health.data.services.MedicalRecordService;
import com.example.Health.models.LabResult;
import com.example.Health.models.MedicalRecord;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class MedicalRecordServiceDbTest {
    private static MedicalRecord mr1 = new MedicalRecord(0, Date.valueOf(LocalDate.now()), "Paracetamol 2 times a day");
    private static MedicalRecord mr2 = new MedicalRecord(0, Date.valueOf(LocalDate.now()), "Aspirin 2 times a day");

    @Autowired
    MedicalRecordService medicalRecordService;

    @Test
    @Order(1)
    public void save(){
        MedicalRecord aSaved = medicalRecordService.save(mr1);
        mr1.setId(aSaved.getId());
        Assertions.assertEquals(mr1,aSaved);
        mr1 = aSaved;
        }

    @Test
    @Order(2)
    public void findById(){
        Optional<MedicalRecord> optional = medicalRecordService.findById (mr1.getId());
        optional.ifPresentOrElse(
                medicalRecord ->Assertions.assertEquals(mr1, medicalRecord),
                () ->Assertions.fail("No medicalRecords")
        );
    }

    }
