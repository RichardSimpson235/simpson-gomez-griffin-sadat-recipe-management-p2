package com.revature.integrations;

import com.revature.models.Recipe;
import com.revature.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = com.revature.driver.Application.class)
@Transactional
public class RecipeIntegrationTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void testFindRecipeById() {
        Optional<Recipe> recipe = recipeRepository.findById(1);

        assertTrue(recipe.isPresent());

        Recipe r = recipe.get();

        assertEquals(r.getRecipe_id(), 1);
        assertEquals(r.getInstruction().size(), 1);
        assertEquals(r.getMedia().size(), 0);
        assertEquals(r.getIngredient().size(), 2);
    }

    @Test
    public void testFindAllRecipes() {
        List<Recipe> recipes = (List<Recipe>) recipeRepository.findAll();

        assertEquals(recipes.size(), 2);
    }
}
