package com.revature.services;

import com.revature.models.Recipe;
import com.revature.models.RecipeDTO;
import com.revature.models.User;
import com.revature.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    RecipeRepository rc;

    @Autowired
    DTOBuilderService dtoBuilderService;

    /**
     * This method is used to save new recipes in the database.
     *
     * @param recipe  Takes a recipe to add/persist into database.
     * @return        a data transfer object of the newly created recipe
     */
    @Override
    public RecipeDTO createRecipe(RecipeDTO recipe) {
        Recipe r = convertDTO(recipe);
        r = rc.save(r);
        return dtoBuilderService.buildRecipeDTO(r);
    }

    /**
     * This method is used to remove a recipe from the database.
     *
     * @param id      Takes a Recipe id to delete from the database.
     */
    @Override
    public void deleteRecipe(int id) {
         rc.deleteById(id);
    }

    /**
     * This method finds a recipe by id.
     *
     * @param id      Takes a Recipe id to retrieve from the database.
     * @return        a data transfer object of the found recipe
     */
    @Override
    public RecipeDTO getRecipeById(int id) {
        Optional<Recipe> recipe = rc.findById(id);
        return recipe.isPresent() ? dtoBuilderService.buildRecipeDTO(recipe.get()) : new RecipeDTO();
    }

    /**
     * This method finds all of the recipes in the database.
     *
     * @return        a list of recipe data transfer objects
     */
    @Override
    public List<RecipeDTO> getAll() {
        List<Recipe> recipes = (List<Recipe>) rc.findAll();
        return recipes.stream().map(dtoBuilderService::buildRecipeDTO).collect(Collectors.toList());
    }

    /**
     * This updates a recipe in the database.
     *
     * @param recipe        The recipe object to be updated in the Database.
     * @return              the updated recipe as a data transfer object
     */
    @Override
    public RecipeDTO updateRecipe(RecipeDTO recipe) {
        Recipe r = convertDTO(recipe);
        r = rc.save(r);
        return dtoBuilderService.buildRecipeDTO(r);
    }

    /**
     * This method finds a recipe by name (or part of a name).
     *
     * @param nameSubstring     A string that matches a Recipe(s) in the Database.
     * @return                  a data transfer object of the recipe
     */
    @Override
    public List<RecipeDTO> search(String nameSubstring) {
        List<Recipe> recipes = (List<Recipe>) rc.findAll();
        return recipes.stream().filter(recipe ->
            recipe.getName().toLowerCase().contains(nameSubstring)
        ).map(dtoBuilderService::buildRecipeDTO).collect(Collectors.toList());
    }

    private Recipe convertDTO(RecipeDTO recipe) {
        Recipe r = new Recipe();
        r.setRecipe_id(recipe.getId());
        r.setName(recipe.getName());
        r.setDescription(recipe.getDescription());
        r.setCook_time(recipe.getCookTime());
        r.setServings(recipe.getServings());
        r.setLikes(recipe.getLikes());
        r.setDislikes(recipe.getDislikes());
        r.setApproved(recipe.isApproved());
        r.setDisapproved(recipe.isDisapproved());

        User u = new User();
        u.setId(recipe.getUser().getId());
        u.setBanned(recipe.getUser().isBanned());
        u.setAdmin(recipe.getUser().isAdmin());
        u.setFirstName(recipe.getUser().getFirstName());
        u.setLastName(recipe.getUser().getLastName());
        u.setUsername(recipe.getUser().getUsername());

        r.setInstruction(recipe.getInstructions());
        r.setMedia(recipe.getMedia());
        r.setIngredient(recipe.getIngredients());

        return r;
    }
}
