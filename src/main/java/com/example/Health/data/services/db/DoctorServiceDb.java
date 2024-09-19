package com.example.Health.data.services.db;

import com.example.Health.data.repositories.DoctorRepository;
import com.example.Health.data.services.DoctorService;
import com.example.Health.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceDb implements DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;
    }
}
