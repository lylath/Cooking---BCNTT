package com.isep.cooking.jsonEntities;

import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class JsonIngredient {
	
    private UUID id;
    private String name;
	
	private List<UUID> usersId;
	private List<UUID> recipesId;
	
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

	public List<UUID> getUsersId() {
		return usersId;
	}

	public void setUsersId(List<UUID> usersId) {
		this.usersId = usersId;
	}

	public List<UUID> getRecipesId() {
		return recipesId;
	}

	public void setRecipesId(List<UUID> recipesId) {
		this.recipesId = recipesId;
	}
}
