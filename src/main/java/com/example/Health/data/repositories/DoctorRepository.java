package com.example.Health.data.repositories;

import com.example.Health.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository< Doctor, Integer> {
}
