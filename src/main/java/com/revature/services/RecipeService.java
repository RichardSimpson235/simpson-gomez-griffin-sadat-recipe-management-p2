package com.revature.services;

import com.revature.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RecipeService {

    /**
     *
     * @param recipe
     * @return
     */
    public Recipe createRecipe(Recipe recipe);

    /**
     *
     * @param id
     * @return
     */
    public boolean deleteRecipe(int id);

    /**
     *
     * @param id
     * @return
     */
    public Recipe getRecipeById(int id);

    /**
     *
     * @return
     */
    public List<Recipe> getAll();

    /**
     *
     * @param recipe
     * @return
     */
    public Recipe updateRecipe(Recipe recipe);

    /**
     *
     * @param nameSubstring
     * @return
     */
    public List<Recipe> search(String nameSubstring);
}
