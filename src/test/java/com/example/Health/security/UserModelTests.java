
package com.example.Health.security;

import com.example.Health.data.services.UserModelService;
import com.example.Health.models.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class UserModelTests {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    UserModelService userModelService;

    @Test
    public void save(){
        UserModel model = new UserModel(0, "a",
                encoder.encode("a"),
                "a@t.com");
        model.setStatus(UserModel.Status.ACTIVE);
        userModelService.save(model);
    }
}

