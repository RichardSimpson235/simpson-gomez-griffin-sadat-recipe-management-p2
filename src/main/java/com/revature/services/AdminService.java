package com.revature.services;

public interface AdminService {

    /**
     * Bans a user.
     *
     * @param id          the id of the user to be banned
     * @return            true when the ban was successful
     */
    public boolean banUser(int id);

    /**
     * Unbans a user.
     *
     * @param id          the id of the user to be unbanned
     * @return            true when the unban was successful
     */
    public boolean unbanUser(int id);

    /**
     * This method sets a recipe to approved.
     *
     * @param id         the id of the recipe to approve
     * @return           true when the approval was successful
     */
    public boolean approveRecipe(int id);

    /**
     * This method sets a recipe to disapproved.
     *
     * @param id         the id of the recipe to disapprove
     * @return           true when the disapproval was successful
     */
    public boolean disapproveRecipe(int id);
}
