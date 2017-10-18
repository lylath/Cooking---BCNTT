package com.isep.cooking.dao;

import com.isep.cooking.entities.Ingredient;
import java.util.List;
import java.util.UUID;
import javax.persistence.EntityManager;


public class IngredientDAO {

     public List<Ingredient> getIngredient() {

        EntityManager em = TransactionManager.initTransaction();

        List<Ingredient> ingredients = em.createQuery("SELECT i FROM Ingredient i", Ingredient.class)
                .getResultList();
        TransactionManager.closeTransaction();

        return ingredients;

    }
    
     public Ingredient getIngredientById(UUID id) {

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
}
