package com.example.Health.data.services;

import com.example.Health.models.Doctor;
import lombok.NonNull;

import java.util.Optional;

public interface DoctorService {
    Doctor save(Doctor doctor);

    Optional<Doctor> findById(@NonNull Integer id);
}
