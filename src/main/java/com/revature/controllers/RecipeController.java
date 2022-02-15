package com.revature.controllers;

import com.revature.models.Recipe;
import com.revature.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipes/search")
    public List<Recipe> searchRecipe(@RequestParam Map<String, String> params) {
        String searchSubstring = params.get("name");
        return recipeService.search(searchSubstring);
    }
}
