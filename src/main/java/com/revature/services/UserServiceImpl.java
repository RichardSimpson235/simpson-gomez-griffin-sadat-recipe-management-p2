package com.revature.services;

import com.revature.models.User;

import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * The UserService Class is used to access and preform CRUD operations on the database.
 *
 */
@Service
public class UserServiceImpl implements UserService{

    /**
     * This is the repository object that User Services will access
     */
    @Autowired
    UserRepository mUserRepository;


    @Override
    public Optional<User> authenticate(String username, String password) {
        return Optional.empty();
    }


    /**
     * This method is used to register a new user account.
     *
     * @param newUser             user data to persist
     * @return                    User object representing their data
     */
    @Override
    public User registerUser(User newUser) {
        return mUserRepository.save(newUser);
    }

    /**
     * This method is used to get the information of a single user by their id.
     *
     * @param id               id of the user to find
     * @return                 Optional with a User object representing their data
     */
    @Override
    public User getUserById(int id) {
        return mUserRepository.findById(id).orElse(new User());
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
        return mUserRepository.save(change);
    }
}
