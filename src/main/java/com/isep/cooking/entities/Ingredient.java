package com.isep.cooking.entities;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingredient implements Serializable {

    @Id
    private UUID id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "ingredients")
    private List<Recipe> recipes;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "ingredients")
    private List<CookingUser> users;

    public Ingredient() {
    }

    public Ingredient(String name, List<Recipe> recipes, List<CookingUser> users) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.recipes = recipes;
        this.users = users;
    }

    private Ingredient(Ingredient toClone) {
        this.id = toClone.id;
        this.name = toClone.name;
    }
    
    public Ingredient getClone() {
        return new Ingredient(this);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Recipe[] getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(Recipe[] recipes) {
//        this.recipes = recipes;
//    }
//
    public List<CookingUser> getUsers() {
        return users;
    }

    public void setUsers(List<CookingUser> users) {
        this.users = users;
    }

//    public List<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(List<Recipe> recipes) {
//        this.recipes = recipes;
//    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}
