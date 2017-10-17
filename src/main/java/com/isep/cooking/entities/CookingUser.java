package com.isep.cooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author Sliveer
 */
@Entity
public class CookingUser implements Serializable {

    @Id
    private UUID id;

    private String FirstName;
    private String LastName;
    private String Password;
    private String Email;
    private int Age;

    /*@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "")       NOT IMPLEMENTED YET
    private Comment[] comments;*/
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Ingredient> ingredients;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Recipe> likedRecipes;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Tool> tools;

    /*@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "")       NOT IMPLEMENTED YET
    private Recipe[] writtenRecipes;*/
    public CookingUser() {
        this.id = UUID.randomUUID();
    }

    private CookingUser(CookingUser toClone) {
        this.id = toClone.id;
        this.FirstName = toClone.FirstName;
        this.LastName = toClone.LastName;
        this.Password = toClone.Password;
        this.Email = toClone.Email;
        this.Age = toClone.Age;
    }
    
    public CookingUser getClone() {
        return new CookingUser(this);
    }

    public CookingUser(String FirstName, String LastName, String Password, String Email, int Age, List<Ingredient> ingredients, Recipe[] likedRecipes) {
        this.id = UUID.randomUUID();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.Email = Email;
        this.Age = Age;
        this.ingredients = ingredients;
//        this.likedRecipes = likedRecipes;
    }

    public CookingUser(String FirstName, String LastName, String Password, String Email, int Age, List<Ingredient> ingredients, List<Recipe> likedRecipes, List<Tool> tools) {
        this.id = UUID.randomUUID();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Password = Password;
        this.Email = Email;
        this.Age = Age;
        this.ingredients = ingredients;
        this.likedRecipes = likedRecipes;
        this.tools = tools;
    }
    
//    public JSONObject toJson() {
//        
//        JSONObject jo = new JSONObject();
//        jo.append("id", id);
//        jo.add(this.id);
//        jo.add(this.id);
//        jo.add(this.id);
//        jo.add(this.id);
//        jo.add(this.id);
//        jo.add(this.id);
//        jo.add(this.id);
//        
//        return jo;
//        
//    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
//
//    public Recipe[] getLikedRecipes() {
//        return likedRecipes;
//    }
//
//    public void setLikedRecipes(Recipe[] likedRecipes) {
//        this.likedRecipes = likedRecipes;
//    }

    public List<Recipe> getLikedRecipes() {
        return likedRecipes;
    }

    public void setLikedRecipes(List<Recipe> likedRecipes) {
        this.likedRecipes = likedRecipes;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

}
