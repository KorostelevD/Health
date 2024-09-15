package com.example.Health.data.repositories;

import com.example.Health.models.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository <Procedure, Integer> {
}
