package com.revature.integrations;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = com.revature.driver.Application.class)
@Transactional
public class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsernameAndPassword() {
        Optional<User> opUser = userRepository.findByUsernameAndPassword("username", "password");

        assertTrue(opUser.isPresent());
    }
}
