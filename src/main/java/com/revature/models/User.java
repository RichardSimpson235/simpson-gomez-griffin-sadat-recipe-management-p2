package com.revature.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
private int id;

    private boolean banned;

}
