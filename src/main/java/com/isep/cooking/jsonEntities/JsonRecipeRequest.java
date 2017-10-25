package com.isep.cooking.jsonEntities;

import java.util.List;


public class JsonRecipeRequest {
	
	private List<String> ingredientIds;

	public JsonRecipeRequest() {
	}

	public JsonRecipeRequest(List<String> ingredientIds) {
		this.ingredientIds = ingredientIds;
	}

	public List<String> getIngredientIds() {
		return ingredientIds;
	}

	public void setIngredientIds(List<String> ingredientIds) {
		this.ingredientIds = ingredientIds;
	}
	
//	private List<String> ingredientIds;
//
//	public JsonRecipeRequest() {
//	}
//
//	public JsonRecipeRequest(List<String> ingredientIds) {
//		this.ingredientIds = ingredientIds;
//	}
//
//	public List<String> getIngredientIds() {
//		return ingredientIds;
//	}
//
//	public void setIngredientIds(List<String> ingredientIds) {
//		this.ingredientIds = ingredientIds;
//	}

}
