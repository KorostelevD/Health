package com.example.Health.data.services.db;

import com.example.Health.data.repositories.MedicalRecordRepository;
import com.example.Health.data.services.MedicalRecordService;
import com.example.Health.models.MedicalRecord;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalRecordServiceDb implements MedicalRecordService {
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Override
    public MedicalRecord save(MedicalRecord medicalRecord) {
        return medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public Optional<MedicalRecord> findById(@NonNull Integer id) {
        Optional<MedicalRecord> optional = medicalRecordRepository.findById(id);
        if (optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;

    }
}
