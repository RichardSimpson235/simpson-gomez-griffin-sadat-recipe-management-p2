package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.driver.Application.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void testAddUser() throws Exception {
        User user = new User();

        user.setId(1);
        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(user);

        when(userService.registerUser(user)).thenReturn(user);
        ResultActions ra = mvc.perform(MockMvcRequestBuilders.post("/register")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        ra.andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$.id").value(1)
        );

    }

    @Test
    public void testGetAllUsers() throws Exception{
       User user = new User();
        List<User> userList = new ArrayList<>();
        userList.add(user);
       when(userService.getAllUsers()).thenReturn(userList);

       ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/users"));

       ra.andExpectAll(
               MockMvcResultMatchers.status().isOk(),
               MockMvcResultMatchers.jsonPath("$").isNotEmpty()
       );
    }

}
