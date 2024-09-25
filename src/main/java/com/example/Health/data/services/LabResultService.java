package com.example.Health.data.services;

import com.example.Health.models.LabResult;
import lombok.NonNull;

import java.util.Optional;

public interface LabResultService {
    LabResult save(LabResult result);

    Optional<LabResult> findById(@NonNull Integer id);
}


