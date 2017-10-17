package com.isep.cooking.utils;

import com.isep.cooking.dao.TransactionManager;
import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Sliveer
 */
public class DBFiller { //RUN THIS FILE TO REPOPULATE THE DATABASE IF IT IS NEEDED (for testing purposes only)
    
    public static void main (String[] args) {
        
        Ingredient i = new Ingredient("pain", null, null);
        CookingUser c = new CookingUser("bob", "lemoch", "abc", "bob@bob.fr", 8, null, null);
        Tool t = new Tool("micro-ondes", null, null);
        Recipe r = new Recipe(100, 100, 100, 100, "pain au pain", 0, 0, null, null, null);
        
        List<CookingUser> users = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        List<Tool> tools = new ArrayList<>();
        List<Recipe> recipes= new ArrayList<>();
        
        ingredients.add(i);
        users.add(c);
        tools.add(t);
        recipes.add(r);
        
        i.setUsers(users);
        i.setRecipes(recipes);
        
        c.setIngredients(ingredients);
        c.setLikedRecipes(recipes);
        c.setTools(tools);
        
        t.setRecipes(recipes);
        t.setUsers(users);
        
        r.setIngredients(ingredients);
        r.setLikers(users);
        r.setTools(tools);
        
        EntityManager em = TransactionManager.initTransaction();
        em.persist(c);
        TransactionManager.closeTransaction();
        
    }
    
}
