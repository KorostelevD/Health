package com.example.Health.data.services.db;

import com.example.Health.data.repositories.UserModelRepository;
import com.example.Health.data.services.UserModelService;
import com.example.Health.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserModelServiceDb implements UserModelService {
    @Autowired
    public UserModelRepository userModelRepository;

    @Override
    public Optional<UserModel> findByLoginIgnoreCase(String login){
        return userModelRepository.findByLoginIgnoreCase(login);
    }

    @Override
    public UserModel save (UserModel userModel){
        return userModelRepository.save(userModel);
    }
}
