package com.isep.cooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;

@Entity
public class Recipe implements Serializable {

	@Id
	private String id;

	private int kcal;
	private int prot;
	private int calc;
	private int carbs;
	private String name;
	
	@Column(length = 3000)
	private String description;
	private int difficulty;
	private int dishesSize;
	//private Date recipeDate;

	/*@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "recipes")
    private CookingUser author;*/
	private List<Integer> quantities;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Ingredient> ingredients;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "likedRecipes")
	private List<CookingUser> likers;
//    //@OneToMany(cascade = CascadeType.MERGE, mappedBy = "likedRecipes")
//    //private Comment[] comments;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Tool> tools;

	public Recipe() {
		this.id = UUID.randomUUID().toString();
	}

	public Recipe(int kcal, int prot, int calc, int carbs, String name,
			String description, int difficulty, int dishesSize, List<Integer> quantities,
			List<Ingredient> ingredients, List<CookingUser> likers,
			List<Tool> tools) {
		
		this.id = UUID.randomUUID().toString();
		this.kcal = kcal;
		this.prot = prot;
		this.calc = calc;
		this.carbs = carbs;
		this.name = name;
		this.description = description;
		this.difficulty = difficulty;
		this.dishesSize = dishesSize;
		this.quantities = quantities;
		this.ingredients = ingredients;
		this.likers = likers;
		this.tools = tools;
		
	}

	public List<String> getIngredientIds() {

		List<String> ans = new ArrayList<>();

		for (Ingredient i : ingredients) {

			ans.add(i.getId());

		}

		return ans;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public List<Integer> getQuantities() {
		return quantities;
	}

	public void setQuantities(List<Integer> quantities) {
		this.quantities = quantities;
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

	public boolean generateId() {
		if (this.id == null) {
			this.id = UUID.randomUUID().toString();
			return true;
		}
		return false;
	}

	public void addIngredient(Ingredient i) {
		this.ingredients.add(i);
	}

	public void addLiker(CookingUser c) {
		this.likers.add(c);
	}

	public void addTool(Tool t) {
		this.tools.add(t);
	}

	public void addQuantity(int s) {
		this.quantities.add(s);
	}

}
