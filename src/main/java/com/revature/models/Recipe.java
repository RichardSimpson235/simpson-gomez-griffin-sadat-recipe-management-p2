package com.revature.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes", schema = "recipeapp")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipe_id;


    private String name;
    private String description;
    private int cook_time, servings, likes, dislikes;
    private boolean approved, disapproved;


    /**
     * Retrieves User data along with the Recipe data
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    /**
     * Retrieves all instructions associated with the Recipe
     */
    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Instruction> instruction;


    /**
     * Retrieves all media associated with the Recipe
     */
    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Media> media;


    /**
     * Retrieves Ingredients list required for the Recipe
     */
    @OneToMany
    @JoinColumn(name = "recipe_id")
    private List<Ingredient> ingredient;

}