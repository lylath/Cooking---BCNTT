package com.isep.cooking.resources;

import com.isep.cooking.dao.RecipeDAO;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.jsonEntities.JsonRecipe;
import com.isep.cooking.jsonEntities.JsonRecipeRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("recipe")
public class RecipeResource {

	RecipeDAO dao = new RecipeDAO();

	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonRecipe> getRecipe() {

		List<Recipe> recipes = dao.getRecipes();
		List<JsonRecipe> jsonRecipes = new ArrayList<>();

		for (Recipe r : recipes) {

			jsonRecipes.add(new JsonRecipe(r));

		}

		return jsonRecipes;

	}

	@POST
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonRecipe getRecipeById(String id) {

		UUID uuid = UUID.fromString(id);

		Recipe recipe = dao.getRecipeById(uuid);
		JsonRecipe jsonRecipe = new JsonRecipe(recipe);

		return jsonRecipe;

	}

	@POST
	@Path("get/withFrigo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonRecipe> getRecipeByIngredients(JsonRecipeRequest request) {
		
		List<Recipe> recipes = dao.getRecipesByIngredients(request.getIngredientIds());
		
		List<JsonRecipe> jsonRecipe = new ArrayList<>();
		
		for (Recipe r : recipes) {
			
			jsonRecipe.add(new JsonRecipe(r));
			
		}

		return jsonRecipe;

	}

	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void postRecipe(Recipe recipe) {

		if (recipe.generateId()) {
			this.dao.persist(recipe);
		}
		
	}

}
