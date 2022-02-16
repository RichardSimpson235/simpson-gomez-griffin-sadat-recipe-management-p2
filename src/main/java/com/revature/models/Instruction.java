package com.revature.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "instructions", schema = "recipeapp")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instruction_id;

}
