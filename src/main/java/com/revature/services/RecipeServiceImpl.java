package com.revature.services;

import com.revature.models.Recipe;
import com.revature.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    RecipeRepository rc;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return rc.save(recipe);
    }

    @Override
    public void deleteRecipe(int id) {
         rc.deleteById(id);
    }

    @Override
    public Recipe getRecipeById(int id) {
        Optional<Recipe> recipe = rc.findById(id);
        return recipe.orElse(new Recipe());
    }

    @Override
    public List<Recipe> getAll() {
        return (List<Recipe>) rc.findAll();
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return rc.save(recipe);
    }

    @Override
    public List<Recipe> search(String nameSubstring) {
        List<Recipe> recipes = (List<Recipe>) rc.findAll();

        return recipes.stream().filter(recipe ->
            recipe.getName().toLowerCase().contains(nameSubstring)
        ).collect(Collectors.toList());

    }
}
