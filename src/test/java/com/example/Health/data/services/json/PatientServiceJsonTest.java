package com.example.Health.data.services.json;

import com.example.Health.data.services.PatientService;
import com.example.Health.data.services.ProcedureService;
import com.example.Health.data.services.qualifiers.PatientServiceDbQualifier;
import com.example.Health.data.services.qualifiers.PatientServiceJsonQualifier;
import com.example.Health.models.Patient;
import com.example.Health.models.Procedure;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientServiceJsonTest {

    @Autowired
    ArrayList<Patient> patientList;
    @Autowired
    ArrayList<Procedure> procedureList;

    @Autowired
    @PatientServiceDbQualifier
    PatientService patientServiceDb;

    @Autowired
    ProcedureService procedureService;

    @Autowired
    @PatientServiceJsonQualifier
    PatientService patientServiceJson;


    @Transactional
    @Commit
    @Test
    @Order(1)
    public void savePatient(){
        List<Patient> savedList = patientServiceDb.saveAll(patientList);
        patientList = new ArrayList<>(savedList);
    }


    @Test
    @Order(2)
    public void saveProcedures(){
      List<Procedure> savedList = procedureService.saveAll(procedureList);
      procedureList = new ArrayList<>(savedList);
        System.err.println(procedureList);
    }

    @Transactional // не закриває транзакцію
    @Test
    @Order(3)
    public void updatePatients() {

        List<Procedure> findProcedures = procedureService.findAll();
        procedureList = new ArrayList<>(findProcedures);
        //
        patientList.get(0).setProcedures(List.of(
                procedureList.get(0),
                procedureList.get(1)

        ));

        patientList.get(1).setProcedures(List.of(
                procedureList.get(1),
                procedureList.get(2)

        ));

        patientList.get(2).setProcedures(List.of(
                procedureList.get(0),
                procedureList.get(1)

        ));

        List<Patient> savedList = patientServiceDb.saveAll(patientList);
        //
        savedList.forEach(patient -> {
            System.out.println(patient);
            patient.getProcedures().forEach(System.out::println);
            System.out.println();
        });
        //
        patientList = new ArrayList<>(savedList);
    }

    @Transactional
    @Test
    @Order(4)
    public void exportJson() {
        System.out.println("Starting export to JSON...");

        // Збереження пацієнтів у JSON
        patientServiceJson.saveAll(patientList);
        System.out.println("Patients saved to JSON: " + patientList.size());

        // Завантаження пацієнтів із JSON
        List<Patient> fromJsonList = patientServiceJson.findAll();
        System.out.println("Patients loaded from JSON: " + fromJsonList.size());

        // Перевірка виводу пацієнтів
        if (!fromJsonList.isEmpty()) {
            fromJsonList.forEach(patient -> {
                System.out.println(patient);
                patient.getProcedures().forEach(System.out::println);
                System.out.println();
            });
        } else {
            System.out.println("No patients found in JSON.");
        }
    }
    }
