package com.revature.services;

import com.revature.models.Recipe;
import com.revature.models.User;

public interface AdminService {

    /**
     * Bans a user.
     *
     * @param user        the user to be banned
     * @return            true when the ban was successful
     */
    public boolean banUser(User user);

    /**
     * Unbans a user.
     *
     * @param user        the user to be unbanned
     * @return            true when the unban was successful
     */
    public boolean unbanUser(User user);

    /**
     * This method sets a recipe to approved.
     *
     * @param recipe     the recipe to approve
     * @return           true when the approval was successful
     */
    public boolean approveRecipe(Recipe recipe);

    /**
     * This method sets a recipe to disapproved.
     *
     * @param recipe     the recipe to disapprove
     * @return           true when the disapproval was successful
     */
    public boolean disapproveRecipe(Recipe recipe);
}
