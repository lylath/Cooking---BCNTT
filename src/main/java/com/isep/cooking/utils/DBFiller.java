package com.isep.cooking.utils;

import com.isep.cooking.dao.IngredientDAO;
import com.isep.cooking.dao.RecipeDAO;
import com.isep.cooking.dao.ToolDAO;
import com.isep.cooking.dao.TransactionManager;
import com.isep.cooking.dao.UserDAO;
import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBFiller { //RUN THIS FILE TO REPOPULATE THE DATABASE IF IT IS NEEDED (for testing purposes only)

	public static void main(String[] args) {

		//EntityManager em = TransactionManager.initTransaction();
		EntityManagerFactory emf
				= Persistence.createEntityManagerFactory("cookingPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		RecipeDAO rDAO = new RecipeDAO();
		IngredientDAO iDAO = new IngredientDAO();
		ToolDAO tDAO = new ToolDAO();

		List<Recipe> recipes = rDAO.getRecipes();
		List<Ingredient> ingredients = iDAO.getIngredient();
		List<Tool> tools = tDAO.getTool();

		List<Ingredient> ifr0 = new ArrayList<>();
		List<Tool> tfr0 = new ArrayList<>();

		ifr0.add(ingredients.get(0));
		ifr0.add(ingredients.get(1));
		ifr0.add(ingredients.get(2));
		ifr0.add(ingredients.get(3));
		ifr0.add(ingredients.get(4));
		ifr0.add(ingredients.get(5));
		ifr0.add(ingredients.get(6));

//		ingredients.get(0).addRecipe(recipes.get(0));
//		ingredients.get(1).addRecipe(recipes.get(0));
//		ingredients.get(2).addRecipe(recipes.get(0));
//		ingredients.get(3).addRecipe(recipes.get(0));
//		ingredients.get(4).addRecipe(recipes.get(0));
//		ingredients.get(5).addRecipe(recipes.get(0));
//		ingredients.get(6).addRecipe(recipes.get(0));
		tfr0.add(tools.get(0));
		tfr0.add(tools.get(1));
		tfr0.add(tools.get(2));
		tfr0.add(tools.get(3));

		recipes.get(0).setIngredients(ifr0);

		recipes.get(0).setTools(tfr0);
		/////////////////////////////////////////////////
		List<Ingredient> ifr1 = new ArrayList<>();
		List<Tool> tfr1 = new ArrayList<>();

		ifr1.add(ingredients.get(1));
		ifr1.add(ingredients.get(7));
		ifr1.add(ingredients.get(8));
		ifr1.add(ingredients.get(9));
		ifr1.add(ingredients.get(10));
		ifr1.add(ingredients.get(11));
		ifr1.add(ingredients.get(21));

//		ingredients.get(1).addRecipe(recipes.get(1));
//		ingredients.get(7).addRecipe(recipes.get(1));
//		ingredients.get(8).addRecipe(recipes.get(1));
//		ingredients.get(9).addRecipe(recipes.get(1));
//		ingredients.get(10).addRecipe(recipes.get(1));
//		ingredients.get(11).addRecipe(recipes.get(1));
//		ingredients.get(21).addRecipe(recipes.get(1));
		tfr1.add(tools.get(4));
		tfr1.add(tools.get(5));
		tfr1.add(tools.get(2));
		tfr1.add(tools.get(3));

		recipes.get(1).setIngredients(ifr1);

		recipes.get(1).setTools(tfr1);
		/////////////////////////////////////////////////
		List<Ingredient> ifr2 = new ArrayList<>();
		List<Tool> tfr2 = new ArrayList<>();

		ifr2.add(ingredients.get(12));
		ifr2.add(ingredients.get(10));
		ifr2.add(ingredients.get(13));
		ifr2.add(ingredients.get(9));
		ifr2.add(ingredients.get(7));
		ifr2.add(ingredients.get(17));
		ifr2.add(ingredients.get(21));

//		ingredients.get(12).addRecipe(recipes.get(2));
//		ingredients.get(10).addRecipe(recipes.get(2));
//		ingredients.get(13).addRecipe(recipes.get(2));
//		ingredients.get(9).addRecipe(recipes.get(2));
//		ingredients.get(7).addRecipe(recipes.get(2));
//		ingredients.get(17).addRecipe(recipes.get(2));
//		ingredients.get(21).addRecipe(recipes.get(2));
		tfr2.add(tools.get(7));
		tfr2.add(tools.get(5));
		tfr2.add(tools.get(2));
		tfr2.add(tools.get(3));
		tfr2.add(tools.get(6));
		tfr2.add(tools.get(8));
		tfr2.add(tools.get(9));

		recipes.get(2).setIngredients(ifr2);

		recipes.get(2).setTools(tfr2);
		/////////////////////////////////////////////////
		List<Ingredient> ifr3 = new ArrayList<>();
		List<Tool> tfr3 = new ArrayList<>();

		ifr3.add(ingredients.get(14));
		ifr3.add(ingredients.get(10));
		ifr3.add(ingredients.get(15));
		ifr3.add(ingredients.get(8));
		ifr3.add(ingredients.get(16));

//		ingredients.get(14).addRecipe(recipes.get(3));
//		ingredients.get(10).addRecipe(recipes.get(3));
//		ingredients.get(15).addRecipe(recipes.get(3));
//		ingredients.get(8).addRecipe(recipes.get(3));
//		ingredients.get(16).addRecipe(recipes.get(3));
		tfr3.add(tools.get(10));
		tfr3.add(tools.get(5));
		tfr3.add(tools.get(3));

		recipes.get(3).setIngredients(ifr3);

		recipes.get(3).setTools(tfr3);
		/////////////////////////////////////////////////
		List<Ingredient> ifr4 = new ArrayList<>();
		List<Tool> tfr4 = new ArrayList<>();

		ifr4.add(ingredients.get(7));
		ifr4.add(ingredients.get(18));
		ifr4.add(ingredients.get(9));
		ifr4.add(ingredients.get(13));
		ifr4.add(ingredients.get(5));
		ifr4.add(ingredients.get(19));
		ifr4.add(ingredients.get(1));
		ifr4.add(ingredients.get(20));
		ifr4.add(ingredients.get(8));

//		ingredients.get(7).addRecipe(recipes.get(4));
//		ingredients.get(18).addRecipe(recipes.get(4));
//		ingredients.get(9).addRecipe(recipes.get(4));
//		ingredients.get(13).addRecipe(recipes.get(4));
//		ingredients.get(5).addRecipe(recipes.get(4));
//		ingredients.get(19).addRecipe(recipes.get(4));
//		ingredients.get(1).addRecipe(recipes.get(4));
//		ingredients.get(20).addRecipe(recipes.get(4));
//		ingredients.get(8).addRecipe(recipes.get(4));
		tfr4.add(tools.get(10));
		tfr4.add(tools.get(5));
		tfr4.add(tools.get(3));

		recipes.get(4).setIngredients(ifr4);

		recipes.get(4).setTools(tfr4);
		//////////////////////////////////////////
//
//		for (Recipe r : recipes) {
//
//			for (Ingredient ings : r.getIngredients()) {
//
//				ings.addRecipe(r);
//
//			}
//
//		}

//		Ingredient pain = new Ingredient("pain", "grammes", new ArrayList<>(), new ArrayList<>());
//		Ingredient chocolat = new Ingredient("chocolat", "grammes", new ArrayList<>(), new ArrayList<>());
//		
		CookingUser bob = new CookingUser("bob", "lemoch", "abc", "", "bob@bob.fr", 8, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//	
//		Tool microOnde = new Tool("micro-ondes", new ArrayList<>(), new ArrayList<>());
//		
//		Recipe painAuPain = new Recipe(100, 100, 100, 100, "pain au pain", "1) prenez le pain\n 2) mangez le", 0, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//		Recipe painAuChocolat = new Recipe(100, 100, 100, 100, "pain au chocolat", "1) prenez le pain\n 2) mettez le chocolat dedans\n 3) mangez le", 0, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
//		
//		pain.addCookingUser(bob);
//		pain.addRecipe(painAuPain);
//		pain.addRecipe(painAuChocolat);
//		
//		chocolat.addRecipe(painAuChocolat);
//		
		bob.addIngredient(ingredients.get(0));
		bob.addIngredient(ingredients.get(1));
		bob.addIngredient(ingredients.get(2));
		bob.addIngredient(ingredients.get(3));
		bob.addIngredient(ingredients.get(4));
		bob.addIngredient(ingredients.get(5));
		bob.addIngredient(ingredients.get(6));
		bob.addIngredient(ingredients.get(7));
		bob.addIngredient(ingredients.get(8));
		bob.addLikedRecipe(recipes.get(0));
		bob.addLikedRecipe(recipes.get(1));
		bob.addLikedRecipe(recipes.get(2));
		bob.addTool(tools.get(0));
		bob.addTool(tools.get(1));
		bob.addTool(tools.get(2));
		bob.addTool(tools.get(3));
		bob.addTool(tools.get(4));
//		
//		microOnde.addUser(bob);
//		microOnde.addRecipe(painAuPain);
//		
//		painAuPain.addLiker(bob);
//		painAuPain.addIngredient(pain);
//		painAuPain.addTool(microOnde);
//		painAuPain.addQuantity(200);
//		
//		painAuChocolat.addIngredient(pain);
//		painAuChocolat.addQuantity(200);
//		painAuChocolat.addIngredient(chocolat);
//		painAuChocolat.addQuantity(25);
//		painAuChocolat.addTool(microOnde);

///////////////////////////////////////////////////////////////
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
		em.persist(bob);
		em.merge(recipes.get(0));
		em.merge(recipes.get(1));
		em.merge(recipes.get(2));
		em.merge(recipes.get(3));
		em.merge(recipes.get(4));
		//TransactionManager.closeTransaction();

		em.getTransaction().commit();
		em.close();

	}

}
