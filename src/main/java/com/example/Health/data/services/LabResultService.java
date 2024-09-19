package com.example.Health.data.services;

import com.example.Health.models.LabResult;

import java.util.Optional;

public interface LabResultService {
    LabResult save(LabResult result);

    Optional<LabResult> findById(Integer id);
}


