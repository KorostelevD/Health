package com.example.Health.data.services;

import com.example.Health.models.Patient;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient save(Patient patient);

    Optional<Patient> findById(@NonNull Integer id);

    List<Patient> saveAll(List<Patient> patients);

    List<Patient> findAll();
}
