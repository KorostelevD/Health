package com.example.Health.data.services;

import com.example.Health.models.Procedure;

import java.util.Optional;

public interface ProcedureService {
    Procedure save(Procedure procedure);

    Optional<Procedure> findById(Integer id);
    
}
