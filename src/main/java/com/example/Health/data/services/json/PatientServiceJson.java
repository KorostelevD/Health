package com.example.Health.data.services.json;

import com.example.Health.data.services.PatientService;
import com.example.Health.models.Patient;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceJson implements PatientService {
    @Override
    public Patient save(Patient patient) {
        return null;
    }

    @Override
    public Optional<Patient> findById(@NonNull Integer id) {
        return Optional.empty();
    }
}
