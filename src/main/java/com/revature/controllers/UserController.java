package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * This method is used to register a new user account.
     *
     * @param user             user data to persist
     * @return                 User object representing their data
     */
    @PostMapping(value = "/register")
    public User addUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    /**
     * This method is used to get all users in the database.
     *
     * @return                 a list of all the users
     */
    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
         return userService.getAllUsers();
    }

}
