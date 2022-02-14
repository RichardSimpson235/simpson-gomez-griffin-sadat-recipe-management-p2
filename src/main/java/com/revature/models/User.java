package com.revature.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Data
@Entity
@Table
public class User {

    private int id;
}
