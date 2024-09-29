package com.example.Health.data.services.json;

import com.example.Health.data.services.PatientService;
import com.example.Health.models.Patient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceJson implements PatientService {
    private final String fileName = this.getClass().getSimpleName() + ".json";
    private final String charset = "UTF-8";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final String FILE_PATH = "C:/ITSTEP/JAVA/DZ/FinalProject/Health/PatientsServiceJson.json";

    @Override
    public Patient save(Patient patient) {
        List<Patient> patients = findAll();
        patients.add(patient);
        saveAll(patients);
        return patient;
    }

    @Override
    public Optional<Patient> findById(@NonNull Integer id) {
        return findAll().stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public List<Patient> saveAll(List<Patient> patients){
        try {
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(patients);
            File file = new File(fileName);
            FileUtils.write(file, json, charset);
        } catch (IOException e) {
            e.printStackTrace(); // Або використовуйте логгер
        }
        return patients;
    }

    @Override
    public List<Patient> findAll() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return List.of(); // Повертає порожній список, якщо файл не існує
            }
            return objectMapper.readValue(file,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Patient.class));
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();  // Повертає порожній список у випадку помилки
        }
    }
}
