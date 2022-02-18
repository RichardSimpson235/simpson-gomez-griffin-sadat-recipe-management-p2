package com.revature.services;

import com.revature.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RecipeService {

    /**
     *
     * @param recipe  Takes a recipe to add/persist into database.
     * @return        The newly added/created Recipe object/data.
     */
    public Recipe createRecipe(Recipe recipe);

    /**
     *
     * @param id      Takes a Recipe id to delete from the database.
     *
     */
    public void deleteRecipe(int id);

    /**
     *
     * @param id      Takes a Recipe id to retrieve from the database.
     * @return        Returns the retrieved Recipe data as an object.
     */
    public Recipe getRecipeById(int id);

    /**
     *
     * @return      Returns the list of all Recipes retrieved from the Database.
     */
    public List<Recipe> getAll();

    /**
     *
     * @param recipe        The recipe object to be updated in the Database.
     * @return              returns the updated Recipe object.
     */
    public Recipe updateRecipe(Recipe recipe);

    /**
     *
     * @param nameSubstring     A string that matches a Recipe(s) in the Database.
     * @return                  The list of all matching Recipe(s).
     */
    public List<Recipe> search(String nameSubstring);
}
