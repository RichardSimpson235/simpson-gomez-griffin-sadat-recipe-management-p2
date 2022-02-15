package com.revature.services;


import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = com.revature.driver.Application.class)
public class RecipeServiceTest {

    @Autowired
    RecipeService rs;

    @MockBean
    RecipeRepository rp;


    @Test
    void createRecipe() {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);
        recipe.setApproved(true);
        recipe.setName("Rice buns");
        recipe.setUser(new User());
        recipe.setServings(3);
        recipe.setCook_time(1);
        recipe.setLikes(3);
        recipe.setDislikes(6);
        recipe.setDescription("Nice Rice buns");

        Mockito.when(rp.save(recipe)).thenReturn(new Recipe());

        recipe = rs.createRecipe(recipe);
        Assertions.assertInstanceOf(Recipe.class, recipe);
    }

    @Test
    void deleteRecipe() {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);
        recipe.setApproved(true);
        recipe.setName("Rice buns");
        recipe.setUser(new User());
        recipe.setServings(3);
        recipe.setCook_time(1);
        recipe.setLikes(3);
        recipe.setDislikes(6);
        recipe.setDescription("Nice Rice buns");


        rs.deleteRecipe(recipe.getRecipe_id());
        Mockito.verify(rp).deleteById(recipe.getRecipe_id());
    }

    @Test
    void getRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);
        recipe.setApproved(true);
        recipe.setName("Rice buns");
        recipe.setUser(new User());
        recipe.setServings(3);
        recipe.setCook_time(1);
        recipe.setLikes(3);
        recipe.setDislikes(6);
        recipe.setDescription("Nice Rice buns");

        Optional<Recipe> optionalRecipe = Optional.of(recipe);
        Mockito.when(rp.findById(recipe.getRecipe_id())).thenReturn(optionalRecipe);

        Recipe r = rs.getRecipeById(recipe.getRecipe_id());
        Assertions.assertEquals(r.getRecipe_id(), recipe.getRecipe_id());
    }

    @Test
    void getAllRecipes() {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);
        recipe.setApproved(true);
        recipe.setName("Rice buns");
        recipe.setUser(new User());
        recipe.setServings(3);
        recipe.setCook_time(1);
        recipe.setLikes(3);
        recipe.setDislikes(6);
        recipe.setDescription("Nice Rice buns");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        Mockito.when(rp.findAll()).thenReturn(recipeList);
        List<Recipe> recipes = rs.getAll();
        Assertions.assertEquals(recipes.get(0), recipeList.get(0));
    }

    @Test
    void updateRecipe() {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);
        recipe.setApproved(true);
        recipe.setName("Rice buns");
        recipe.setUser(new User());
        recipe.setServings(3);
        recipe.setCook_time(1);
        recipe.setLikes(3);
        recipe.setDislikes(6);
        recipe.setDescription("Nice Rice buns");


        Mockito.when(rp.save(recipe)).thenReturn(new Recipe(
                2,"salad", "nice salad", 10,
                4, 0, 0, false, new User())
        );
        recipe.setRecipe_id(2);
        Recipe recipe1 = rs.updateRecipe(recipe);

        Assertions.assertEquals(recipe1.getRecipe_id(), recipe.getRecipe_id());

    }

    @Test
    void searchRecipe() {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);
        recipe.setApproved(true);
        recipe.setName("Rice buns");
        recipe.setUser(new User());
        recipe.setServings(3);
        recipe.setCook_time(1);
        recipe.setLikes(3);
        recipe.setDislikes(6);
        recipe.setDescription("Nice Rice buns");


        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        Mockito.when(rp.findAll()).thenReturn(recipeList);
        List<Recipe> recipes = rs.search("rice");
        Assertions.assertEquals(recipes.get(0).getName(), recipeList.get(0).getName());
    }


}
