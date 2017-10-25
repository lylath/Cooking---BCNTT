package com.isep.cooking.utils;

import com.isep.cooking.dao.TransactionManager;
import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

public class DBFiller { //RUN THIS FILE TO REPOPULATE THE DATABASE IF IT IS NEEDED (for testing purposes only)

	public static void main(String[] args) {

		Ingredient pain = new Ingredient("pain", new ArrayList<>(), new ArrayList<>());
		Ingredient chocolat = new Ingredient("chocolat", new ArrayList<>(), new ArrayList<>());
		
		CookingUser bob = new CookingUser("bob", "lemoch", "abc", "bob@bob.fr", 8, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		
		Tool microOnde = new Tool("micro-ondes", new ArrayList<>(), new ArrayList<>());
		
		Recipe painAuPain = new Recipe(100, 100, 100, 100, "pain au pain", 0, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		Recipe painAuChocolat = new Recipe(100, 100, 100, 100, "pain au chocolat", 0, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
		
		pain.addCookingUser(bob);
		pain.addRecipe(painAuPain);
		pain.addRecipe(painAuChocolat);
		
		chocolat.addRecipe(painAuChocolat);
		
		bob.addIngredient(pain);
		bob.addLikedRecipe(painAuPain);
		bob.addTool(microOnde);
		
		microOnde.addUser(bob);
		microOnde.addRecipe(painAuPain);
		
		painAuPain.addLiker(bob);
		painAuPain.addIngredient(pain);
		painAuPain.addTool(microOnde);
		
		painAuChocolat.addIngredient(pain);
		painAuChocolat.addIngredient(chocolat);
		painAuChocolat.addTool(microOnde);

//		List<CookingUser> users = new ArrayList<>();
//		List<Ingredient> ingredients = new ArrayList<>();
//		//List<Ingredient> ingredients2 = new ArrayList<>();
//		List<Tool> tools = new ArrayList<>();
//		List<Recipe> recipes = new ArrayList<>();
//		//List<Recipe> recipes2 = new ArrayList<>();
//
//		ingredients.add(pain);
//		//ingredients2.add(i);
//		//ingredients2.add(i2);
//		users.add(bob);
//		tools.add(microOnde);
//		recipes.add(painAuPain);
//		//recipes2.add(r2);
//
//		pain.setUsers(users);
//		pain.setRecipes(recipes);
//		//i2.setRecipes(recipes2);
//
//		bob.setIngredients(ingredients);
//		bob.setLikedRecipes(recipes);
//		bob.setTools(tools);
//
//		microOnde.setRecipes(recipes);
//		microOnde.setUsers(users);
//
//		painAuPain.setIngredients(ingredients);
//		painAuPain.setLikers(users);
//		painAuPain.setTools(tools);

		EntityManager em = TransactionManager.initTransaction();
		em.persist(bob);
		TransactionManager.closeTransaction();

	}

}
