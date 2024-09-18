package com.example.Health.data.services.db;

import com.example.Health.data.repositories.DoctorRepository;
import com.example.Health.data.services.DoctorService;
import com.example.Health.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceDb implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor1) {
        return doctorRepository.save(doctor1);
    }
}
