package com.example.Health.data.services;

import com.example.Health.models.UserModel;

import java.util.Optional;

public interface UserModelService {
    Optional<UserModel> findByLoginIgnoreCase(String login);

    UserModel save(UserModel userModel);
}
