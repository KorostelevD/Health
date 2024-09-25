package com.example.Health.data.services.db;

import com.example.Health.data.repositories.ProcedureRepository;
import com.example.Health.data.services.ProcedureService;
import com.example.Health.models.Procedure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceDb implements ProcedureService {
    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public Procedure save(Procedure procedure) {
        return procedureRepository.save(procedure);
    }
}
