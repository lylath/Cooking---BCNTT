package com.isep.cooking.dao;

import com.isep.cooking.entities.Ingredient;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;

public class IngredientDAO {

	public List<Ingredient> getIngredient() {

		EntityManager em = TransactionManager.initTransaction();

		List<Ingredient> ingredients = em.createQuery(
				"SELECT i FROM Ingredient i",
				Ingredient.class)
				.getResultList();
		TransactionManager.closeTransaction();

		return ingredients;

	}

	public Ingredient getIngredientById(String id) {

		EntityManager em = TransactionManager.initTransaction();

		Ingredient ingredient = em.find(Ingredient.class, id);

		TransactionManager.closeTransaction();

		return ingredient;

	}

	public void persist(Ingredient ingredient) {

		EntityManager em = TransactionManager.initTransaction();

		em.persist(ingredient);

		TransactionManager.closeTransaction();

	}

	public List<Ingredient> getIngredientsById(List<String> ids) {

		EntityManager em = TransactionManager.initTransaction();

		String ingredientIds = this.createGroup(ids);

		List<Ingredient> ingredients = em.createQuery(
				"SELECT i FROM Ingredient i WHERE i.id IN " + ingredientIds,
				Ingredient.class)
				.getResultList();
		TransactionManager.closeTransaction();

		return ingredients;

	}

	public List<Ingredient> getIngredientsByUser(String userId) {

		EntityManager em = TransactionManager.initTransaction();

		List<Ingredient> ingredients = em.createNativeQuery(
				"SELECT * FROM INGREDIENT WHERE INGREDIENT.ID = "
				+ "(SELECT INGREDIENTS_ID FROM COOKINGUSER_INGREDIENT "
				+ "WHERE USERS_ID = '" + userId + "')",
				Ingredient.class).getResultList();

		TransactionManager.closeTransaction();
		
		return ingredients;

	}
	
	public List<String> getIngredientIdsByUser(String userId) {
		
		EntityManager em = TransactionManager.initTransaction();

		List<String> ingredientIds = em.createNativeQuery(
				"SELECT INGREDIENTS_ID FROM COOKINGUSER_INGREDIENT "
				+ "WHERE USERS_ID = '" + userId + "'").getResultList();

		TransactionManager.closeTransaction();
		
		return ingredientIds;
		
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
