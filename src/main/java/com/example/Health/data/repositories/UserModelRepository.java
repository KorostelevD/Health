package com.example.Health.data.repositories;

import com.example.Health.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserModelRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByLoginIgnoreCase(String login);


}