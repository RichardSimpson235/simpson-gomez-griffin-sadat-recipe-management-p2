package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    private String amount;

    @ManyToOne
    @JoinColumn(name="foodstuff_id")
    private Foodstuff item;

    public String getName() {
        return item.getName();
    }

    public void setName(String name) {
        item.setName(name);
    }
}
