package com.example.Health.data.services.db;

import com.example.Health.data.repositories.ProcedureRepository;
import com.example.Health.data.services.ProcedureService;
import com.example.Health.models.Procedure;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProcedureServiceDb implements ProcedureService {
    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public Procedure save(Procedure procedure) {
        return procedureRepository.save(procedure);
    }

    @Override
    public Optional<Procedure> findById(@NonNull Integer id) {
        Optional<Procedure> optional = procedureRepository.findById(id);
        //-
        if (optional.isEmpty()){
            System.err.println("Optional Empty");
        }
        return optional;
    }
}
