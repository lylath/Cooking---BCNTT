package com.isep.cooking.jsonEntities;

import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.entities.Tool;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JsonRecipe {

	private String id;

	private int kcal;
	private int prot;
	private int calc;
	private int carbs;
	private String name;
	private int difficulty;
	private int dishesSize;
	private String description;
	
	private List<Integer> quantities;
	private List<String> ingredientsId;
	private List<String> toolsId;
	private List<String> likersId;

	public JsonRecipe(Recipe toClone) {
		
		this.id = toClone.getId();
		this.kcal = toClone.getKcal();
		this.prot = toClone.getProt();
		this.calc = toClone.getCalc();
		this.carbs = toClone.getCarbs();
		this.name = toClone.getName();
		this.difficulty = toClone.getDifficulty();
		this.dishesSize = toClone.getDishesSize();
		this.description = toClone.getDescription();
		this.quantities = toClone.getQuantities();

		this.retrieveEntitiesId(toClone);
		
	}

	private void retrieveEntitiesId(Recipe toClone) {

		this.ingredientsId = new ArrayList<>();
		this.toolsId = new ArrayList<>();
		this.likersId = new ArrayList<>();

		for (Ingredient i : toClone.getIngredients()) {

			this.ingredientsId.add(i.getId());

		}

		for (Tool t : toClone.getTools()) {

			this.toolsId.add(t.getId());

		}

		for (CookingUser u : toClone.getLikers()) {

			this.likersId.add(u.getId());

		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		this.prot = prot;
	}

	public int getCalc() {
		return calc;
	}

	public void setCalc(int calc) {
		this.calc = calc;
	}

	public int getCarbs() {
		return carbs;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public int getDishesSize() {
		return dishesSize;
	}

	public void setDishesSize(int dishesSize) {
		this.dishesSize = dishesSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<String> getLikersId() {
		return likersId;
	}

	public void setLikersId(List<String> likersId) {
		this.likersId = likersId;
	}
}
