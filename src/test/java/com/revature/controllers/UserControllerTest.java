package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Optional;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.driver.Application.class)
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    private MockMvc mvc;

    @Test
    void getUserById() throws Exception {
        User user = new User();
        user.setUser_id(1);

        when(userService.getUserById(1)).thenReturn(Optional.of(new User()));

        ResultActions rs = mvc.perform(MockMvcRequestBuilders.get("/users/1"));
        rs.andExpect(MockMvcResultMatchers.status().isOk());

    }
}
