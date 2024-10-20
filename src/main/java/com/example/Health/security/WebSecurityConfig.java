package com.example.Health.security;


import com.example.Health.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
 //Авторизація в пам'яті
    //1
    //@Bean
    public UserDetailsService userDetailsService_1(){
        UserDetails admin = User.withUsername("a")
                .password("a")
                .roles(UserModel.Role.ADMIN.name())
                .build();

        UserDetails user = User.withUsername("u")
                .password("u")
                .roles(UserModel.Role.USER.name())
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    //@Bean
    public PasswordEncoder passwordEncoder_1(){
        return NoOpPasswordEncoder.getInstance();
    }

    //2
    //@Bean
    public UserDetailsService userDetailsService(){
        System.err.println("userDetailsService");
        System.err.println(encoder);
        UserDetails admin = User.withUsername("a")
                .password(encoder.encode("a"))
                .roles(UserModel.Role.ADMIN.name())
                .build();

        UserDetails user = User.withUsername("u")
                .password(encoder.encode("u"))
                .roles(UserModel.Role.USER.name())
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Autowired
    @Lazy
    private PasswordEncoder encoder;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
