package com.revature.controllers;

import com.revature.models.Recipe;
import com.revature.models.User;
import com.revature.services.RecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest(classes = com.revature.driver.Application.class)
public class RecipeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RecipeService recipeService;

    @Test
    public void testSearchByName() throws Exception {
        Recipe rice = new Recipe();
        rice.setName("Rice pilaf");
        List<Recipe> riceRecipes = new ArrayList<>();
        riceRecipes.add(rice);
        when(recipeService.search("rice")).thenReturn(riceRecipes);

        ResultActions ra = mvc.perform(MockMvcRequestBuilders.get("/recipes/search?name=rice"));

        ra.andExpectAll(
                MockMvcResultMatchers.status().isOk(),
                MockMvcResultMatchers.jsonPath("$[0].name").value("Rice pilaf")
        );
    }


    @Test
    void getAllRecipes() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setName("Rice bun");
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        when(recipeService.getAll()).thenReturn(recipeList);

        ResultActions rs = mvc.perform(MockMvcRequestBuilders.get("/recipes"));
        rs.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getRecipeById() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setRecipe_id(1);

        when(recipeService.getRecipeById(1)).thenReturn(new Recipe());

        ResultActions rs = mvc.perform(MockMvcRequestBuilders.get("/recipes/1"));
        rs.andExpect(MockMvcResultMatchers.status().isOk());

    }
}
