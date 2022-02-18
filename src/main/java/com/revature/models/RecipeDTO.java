package com.revature.models;

import lombok.Data;

import java.util.List;

@Data
public class RecipeDTO {

    private int id;
    private String name;
    private String description;
    private String cookTime;
    private int servings;
    private boolean approved;

    private UserDTO user;

    private List<Instruction> instructions;

    private List<Media> media;

    private List<Ingredient> ingredients;
}
