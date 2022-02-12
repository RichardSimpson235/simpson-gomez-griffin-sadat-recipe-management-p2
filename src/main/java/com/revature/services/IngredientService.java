package com.revature.services;

import com.revature.models.Ingredient;

import java.util.List;

public interface IngredientService {

    /**
     * This method fills out the details of the ingredient objects from the api.
     * @param ingredient             the ingredient to supplement
     * @return                       supplemented ingredient
     */
    public Ingredient getDetails(Ingredient ingredient);

    /**
     * This method goes through each ingredient and calls the api to get the detail
     * data.
     *
     * @param ingredients           the ingredients to supplement
     * @return                      the ingredients to supplement
     */
    public List<Ingredient> getDetails(List<Ingredient> ingredients);
}
