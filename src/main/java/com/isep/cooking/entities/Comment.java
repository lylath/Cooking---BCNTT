package com.isep.cooking.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//@Entity
public class Comment implements Serializable {      //NOT IMPLEMENTED YET
/*
    @Id
    private UUID id;
    private Date commentDate;
    private String content;
    
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "comments")
    private Recipe recipe;
    
    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "comments")
    private CookingUser author;*/

}
