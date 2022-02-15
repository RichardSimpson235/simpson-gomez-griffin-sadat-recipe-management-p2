package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="media")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id", updatable = false)
    private int id;

    // type is the file extension
    private String type;
    private String title;

    @Transient
    private File data;
}
