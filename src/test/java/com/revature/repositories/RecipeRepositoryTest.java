package com.revature.repositories;


import com.revature.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = com.revature.driver.Application.class)
@Transactional
public class RecipeRepositoryTest {


    @Autowired
    public RecipeRepository rp;

    @Test
    void addRecipe() {
        User user = new User();
        user.setUser_id(1);


        Recipe recipe = new Recipe();
        recipe.setUser(user);


        recipe = rp.save(recipe);
        Assertions.assertNotEquals(0, recipe.getRecipe_id());
    }

    @Test
    void updateRecipe() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setUser(user);


        Recipe recipe2 = recipe;
        recipe2.setName("Tofu");
        recipe2 = rp.save(recipe2);
        Assertions.assertNotEquals("", recipe2.getName());
    }

    @Test
    void deleteRecipeById() {
        User user = new User();
        user.setUser_id(1);
        Recipe recipe = new Recipe();
        recipe.setUser(user);


        Recipe r = rp.save(recipe);
        rp.deleteById(r.getRecipe_id());

    }

    @Test
    void gelAllRecipe() {
        List<Recipe> recipes = (List<Recipe>) rp.findAll();
        System.out.println(recipes);
        Assertions.assertFalse(recipes.isEmpty());

    }
}
