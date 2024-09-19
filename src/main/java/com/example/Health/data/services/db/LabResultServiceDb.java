package com.example.Health.data.services.db;

import com.example.Health.data.repositories.LabResultRepository;
import com.example.Health.data.services.LabResultService;
import com.example.Health.models.LabResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LabResultServiceDb implements LabResultService {
    @Autowired
    private LabResultRepository labResultRepository;

    @Override
    public LabResult save(LabResult result) {
        return labResultRepository.save(result);
    }

    @Override
    public Optional<LabResult> findById(Integer id) {
        Optional<LabResult> optional = labResultRepository.findById(id);
        if (optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;
    }
}
