package com.revature.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "ingredients", schema = "recipeapp")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ingredient_id;
}
