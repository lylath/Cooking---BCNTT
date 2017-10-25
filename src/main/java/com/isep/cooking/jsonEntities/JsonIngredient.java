package com.isep.cooking.jsonEntities;

import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonIngredient {

	private String id;
	private String name;

	private List<String> usersId;
	private List<String> recipesId;

	public JsonIngredient(Ingredient toClone) {

		this.id = toClone.getId();
		this.name = toClone.getName();

		this.retrieveEntitiesId(toClone);

	}

	private void retrieveEntitiesId(Ingredient toClone) {

		this.recipesId = new ArrayList<>();
		this.usersId = new ArrayList<>();

		for (Recipe r : toClone.getRecipes()) {

			this.recipesId.add(r.getId());

		}

		for (CookingUser u : toClone.getUsers()) {

			this.usersId.add(u.getId());

		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getUsersId() {
		return usersId;
	}

	public void setUsersId(List<String> usersId) {
		this.usersId = usersId;
	}

	public List<String> getRecipesId() {
		return recipesId;
	}

	public void setRecipesId(List<String> recipesId) {
		this.recipesId = recipesId;
	}
}
