package com.example.Health.data.services.db;

import com.example.Health.data.repositories.PatientRepository;
import com.example.Health.data.services.PatientService;
import com.example.Health.models.Patient;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceDb implements PatientService {
    @Autowired
    private PatientRepository patientRepository;


    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(@NonNull Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;
    }
}
