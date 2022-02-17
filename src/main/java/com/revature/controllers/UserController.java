package com.revature.controllers;


import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;


    /**
     * Method retrieves a Users data from the database/backend by an id.
     *
     * @param id    The id of the User to be retrieved
     * @return      Returns the retrieved User data from the database.
     */
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.getUserById(Integer.parseInt(id));

        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/register")
    public User addUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    }
