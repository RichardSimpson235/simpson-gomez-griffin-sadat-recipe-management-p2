package com.revature.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "media", schema = "recipeapp")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int media_id;
}
