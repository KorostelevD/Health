package com.example.Health.security;

import com.example.Health.data.services.UserModelService;
import com.example.Health.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserModelService userModelService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.err.println("loadUserByUsername");
        System.err.println(username);

        Optional<UserModel> optionalUserModel = userModelService.findByLoginIgnoreCase(username);
               if (optionalUserModel.isPresent()){
            System.err.println(optionalUserModel.get());
            return new UsedDetailsImpl(optionalUserModel.get());

        }
        System.err.println("User non found!");
        throw new UsernameNotFoundException("User not found!");
    }
}
