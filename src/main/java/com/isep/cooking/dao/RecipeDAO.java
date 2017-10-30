package com.isep.cooking.dao;

import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;

public class RecipeDAO {

	public List<Recipe> getRecipes() {

		EntityManager em = TransactionManager.initTransaction();

		List<Recipe> recipes = em.createQuery("SELECT r FROM Recipe r",
				Recipe.class)
				.getResultList();
		TransactionManager.closeTransaction();

		return recipes;

	}

	public Recipe getRecipeById(String id) {

		EntityManager em = TransactionManager.initTransaction();

		Recipe recipe = em.find(Recipe.class, id);

		TransactionManager.closeTransaction();

		return recipe;

	}

	public List<Recipe> getRecipesByIngredients(List<String> ingredientsId) {

		List<Recipe> answer = new ArrayList<>();

		EntityManager em = TransactionManager.initTransaction();

		String ingredientList = this.createGroup(ingredientsId);

		List<Recipe> recipes = em.createNativeQuery(
				"SELECT * FROM RECIPE WHERE ID IN "
				+ "(SELECT RECIPES_ID FROM RECIPE_INGREDIENT "
				+ "WHERE INGREDIENTS_ID IN " + ingredientList + ")",
				Recipe.class).getResultList();

		answer.addAll(recipes);
		for (Recipe r : recipes) {
			for (Ingredient i : r.getIngredients()) {
				if (!ingredientsId.contains(i.getId())) {
					answer.remove(r);
					break;
				}
			}
		}

		TransactionManager.closeTransaction();

		return answer;

	}

	public void persist(Recipe recipe) {

		EntityManager em = TransactionManager.initTransaction();

		em.persist(recipe);

		TransactionManager.closeTransaction();

	}

	private String createGroup(List<String> s) {

		String group = "(";
		for (String element : s) {
			group += "'" + element + "', ";
		}
		group += "'0')";
		
		return group;

	}

}
