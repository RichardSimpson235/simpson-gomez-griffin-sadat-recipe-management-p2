package com.revature.services;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import com.revature.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    @Transactional
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
     * @param user        the user to be unbanned
     * @return            true when the unban was successful
     */
    @Transactional
    @Override
    public boolean unbanUser(User user) {
        user.setBanned(false);
        User usr = userRepository.save(user);

        return user.isBanned() == usr.isBanned();
    }

    /**
     * Approves a recipe. This method sets the approved attribute to true
     * and then confirms that the entity retrieved from the database
     * has the update.
     *
     * @param recipe     the recipe to approve
     * @return           true when the approval was successful
     */
    @Transactional
    @Override
    public boolean approveRecipe(Recipe recipe) {
        recipe.setApproved(true);
        Recipe r = recipeRepository.save(recipe);

        return recipe.isApproved() == r.isApproved();
    }

    /**
     * Disapproves a recipe. This method sets the disapproved attribute to true
     * and then confirms that the entity retrieved from the database
     * has the update.
     *
     * @param recipe     the recipe to disapprove
     * @return           true when the disapproval was successful
     */
    @Transactional
    @Override
    public boolean disapproveRecipe(Recipe recipe) {
        recipe.setDisapproved(true);
        Recipe r = recipeRepository.save(recipe);

        return recipe.isDisapproved() == r.isDisapproved();
    }
}
