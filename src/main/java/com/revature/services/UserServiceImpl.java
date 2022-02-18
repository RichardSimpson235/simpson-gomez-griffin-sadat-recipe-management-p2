package com.revature.services;

import com.revature.models.User;

import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * This method is used to authenticate the user.
     *
     * @param username          username of the user
     * @param password          password of the user
     * @return                  Optional with a User object representing their data
     */
    @Transactional
    @Override
    public Optional<User> authenticate(String username, String password) {

        return userRepository.findByUsernameAndPassword(username, password);
    }

    /**
     * This method is used to get all of the users in the database.
     *
     * @return                 a list of all the users
     */
    @Override
    public List<User> getAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    /**
     * This method is used to register a new user account.
     *
     * @param newUser             user data to persist
     * @return                    User object representing their data
     */
    @Override
    public User registerUser(User newUser) {
        return userRepository.save(newUser);
    }

    /**
     * This method is used to get the information of a single user by their id.
     *
     * @param id               id of the user to find
     * @return                 Optional with a User object representing their data
     */
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public List<User> getAllUsers() {

        return null;
    }

    /**
     * This method is used to modify a user's account information.
     *
     * @param change            the the actual changes/updates to the user object
     * @return                  the modified user object gotten from the database
     */
    @Override
    public User updateUser(User change) {
        return userRepository.save(change);
    }
}
