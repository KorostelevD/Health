package com.example.Health.data.services.db;

import com.example.Health.data.services.LabResultService;
import com.example.Health.models.LabResult;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class LabresultServiceDbTest {
    private static LabResult res1 = new LabResult(0, Date.valueOf(LocalDate.now()),"good anslysis");
    private static LabResult res2 = new LabResult(0, Date.valueOf(LocalDate.now()),"bed anslysis");

    @Autowired
    LabResultService labResultService;

    @Test
    @Order(1)
    public void save(){
        LabResult aSaved = labResultService.save(res2);
        res2.setId(aSaved.getId());
        Assertions.assertEquals(res2,aSaved);
    }


}
