package com.example.Health.data.services;

import com.example.Health.models.MedicalRecord;
import lombok.NonNull;

import java.util.Optional;

public interface MedicalRecordService {

    MedicalRecord save(MedicalRecord medicalRecord);

    Optional<MedicalRecord> findById(@NonNull Integer id);
}
