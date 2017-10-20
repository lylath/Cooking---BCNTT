package com.isep.cooking.dao;

import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;

public class RecipeDAO {

	public List<Recipe> getRecipes() {

		EntityManager em = TransactionManager.initTransaction();

		List<Recipe> recipes = em.createQuery("SELECT r FROM Recipe r", Recipe.class)
				.getResultList();
		TransactionManager.closeTransaction();

		return recipes;

	}

	public Recipe getRecipeById(UUID id) {

		EntityManager em = TransactionManager.initTransaction();

		Recipe recipe = em.find(Recipe.class, id);

		TransactionManager.closeTransaction();

		return recipe;

	}

	public void persist(Recipe recipe) {

		EntityManager em = TransactionManager.initTransaction();

		em.persist(recipe);

		TransactionManager.closeTransaction();

	}

}
