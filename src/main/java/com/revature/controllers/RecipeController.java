package com.revature.controllers;

import com.revature.models.Recipe;
import com.revature.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    /**
     * This method serves the search endpoint. It requires a query parameter and uses
     * those parameters to search. Currently only supports the name substring.
     *
     * @param params            parameter map of the query parameters of the request
     * @return                  returns a response body list of recipes
     */
    @GetMapping("/recipes/search")
    public List<Recipe> searchRecipe(@RequestParam Map<String, String> params) {
        String searchSubstring = params.get("name");
        return recipeService.search(searchSubstring);
    }


    /**
     * Method generates all approved recipes in the database
     *
     * @return      The list of all approved recipes in the database
     */
    @GetMapping("/recipes")
    public List<Recipe> allRecipes() {
        return recipeService.getAll();
    }

    /**
     * Method retrieves a recipe from the database/backend by an id.
     *
     * @param id    The id of Recipe to be retrieved
     * @return      Returns the retrieved Recipe data from the database.
     */
    @GetMapping("/recipes/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable String id) {
        Recipe recipe = recipeService.getRecipeById(Integer.parseInt(id));
        return recipe != null ? new ResponseEntity<>(recipe, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
