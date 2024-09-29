package com.example.Health.data.services;

import com.example.Health.models.Procedure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ProcedureService {
    Procedure save(Procedure procedure);

    Optional<Procedure> findById(Integer id);

    List<Procedure> saveAll (List<Procedure> procedures);

    List<Procedure> findAll();
}

