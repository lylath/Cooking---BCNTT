package com.isep.cooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@Entity
public class Recipe implements Serializable {

	@Id
	private UUID id;

	private int kcal;
	private int prot;
	private int calc;
	private int carbs;
	private String name;
	private int difficulty;
	private int dishesSize;
	//private Date recipeDate;

	/*@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "recipes")
    private CookingUser author;*/
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Ingredient> ingredients;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "likedRecipes")
	private List<CookingUser> likers;
//    //@OneToMany(cascade = CascadeType.MERGE, mappedBy = "likedRecipes")
//    //private Comment[] comments;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Tool> tools;

	public Recipe() {
		this.id = UUID.randomUUID();
	}

	public Recipe(int kcal, int prot, int calc, int carbs, String name, int difficulty, int dishesSize, List<Ingredient> ingredients, List<CookingUser> likers, List<Tool> tools) {
		this.id = UUID.randomUUID();
		this.kcal = kcal;
		this.prot = prot;
		this.calc = calc;
		this.carbs = carbs;
		this.name = name;
		this.difficulty = difficulty;
		this.dishesSize = dishesSize;
		this.ingredients = ingredients;
		this.likers = likers;
		this.tools = tools;
	}

	public List<UUID> getIngredientIds() {

		List<UUID> ans = new ArrayList<>();

		for (Ingredient i : ingredients) {

			ans.add(i.getId());

		}

		return ans;

	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public List<CookingUser> getLikers() {
		return likers;
	}

	public void setLikers(List<CookingUser> likers) {
		this.likers = likers;
	}

	public List<Tool> getTools() {
		return tools;
	}

	public void setTools(List<Tool> tools) {
		this.tools = tools;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public void generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID();
		}
	}

}
