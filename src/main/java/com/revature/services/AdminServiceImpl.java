package com.revature.services;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    /**
     * Bans a user. This method sets the banned attribute to true
     * and then confirms that the entity retrieved from the database
     * has the update.
     *
     * @param user        the user to be banned
     * @return            true when the ban was successful
     */
    @Override
    public boolean banUser(User user) {
        user.setBanned(true);
        User usr = userRepository.save(user);

        return user.isBanned() == usr.isBanned();
    }

    /**
     * Unbans a user. This method sets the banned attribute to false
     * and then confirms that the entity retrieved from the database
     * has the update.
     *
     * @param user        the user to be banned
     * @return            true when the ban was successful
     */
    @Override
    public boolean unbanUser(User user) {
        user.setBanned(false);
        User usr = userRepository.save(user);

        return user.isBanned() == usr.isBanned();
    }

    @Override
    public boolean approveRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean disapproveRecipe(Recipe recipe) {
        return false;
    }
}
