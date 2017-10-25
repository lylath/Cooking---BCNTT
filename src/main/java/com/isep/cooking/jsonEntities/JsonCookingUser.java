package com.isep.cooking.jsonEntities;

import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonCookingUser {

	private String id;

	private String FirstName;
	private String LastName;
	private String Password;
	private String Email;
	private int Age;

	private List<String> ingredientsId;
	private List<String> toolsId;
	private List<String> likedRecipesId;

	public JsonCookingUser(CookingUser toClone) {

		this.id = toClone.getId();
		this.FirstName = toClone.getFirstName();
		this.LastName = toClone.getLastName();
		this.Password = toClone.getPassword();
		this.Email = toClone.getEmail();
		this.Age = toClone.getAge();

		this.retrieveEntitiesId(toClone);

	}

	private void retrieveEntitiesId(CookingUser toClone) {

		this.ingredientsId = new ArrayList<>();
		this.toolsId = new ArrayList<>();
		this.likedRecipesId = new ArrayList<>();

		for (Ingredient i : toClone.getIngredients()) {

			this.ingredientsId.add(i.getId());

		}

		for (Tool t : toClone.getTools()) {

			this.toolsId.add(t.getId());

		}

		for (Recipe r : toClone.getLikedRecipes()) {

			this.likedRecipesId.add(r.getId());

		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<String> getIngredientsId() {
		return ingredientsId;
	}

	public void setIngredientsId(List<String> ingredientsId) {
		this.ingredientsId = ingredientsId;
	}

	public List<String> getToolsId() {
		return toolsId;
	}

	public void setToolsId(List<String> toolsId) {
		this.toolsId = toolsId;
	}

	public List<String> getLikedRecipesId() {
		return likedRecipesId;
	}

	public void setLikedRecipesId(List<String> likedRecipesId) {
		this.likedRecipesId = likedRecipesId;
	}

}
