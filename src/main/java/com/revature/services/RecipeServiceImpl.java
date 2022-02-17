package com.revature.services;

import com.revature.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService{
    @Override
    public Recipe createRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public boolean deleteRecipe(int id) {
        return false;
    }

    @Override
    public Recipe getRecipeById(int id) {
        return null;
    }

    @Override
    public List<Recipe> getAll() {
        return null;
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public List<Recipe> search(String nameSubstring) {
        return null;
    }
}
