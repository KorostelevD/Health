package com.example.Health.data.services;

import com.example.Health.models.Doctor;

import java.util.Optional;

public interface DoctorService {
    Doctor save(Doctor doctor);

    Optional<Doctor> findById(Integer id);
}
