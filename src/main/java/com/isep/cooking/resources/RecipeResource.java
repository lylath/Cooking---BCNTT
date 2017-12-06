package com.isep.cooking.resources;

import com.isep.cooking.dao.IngredientDAO;
import com.isep.cooking.dao.RecipeDAO;
import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.entities.Recipe;
import com.isep.cooking.jsonEntities.JsonCookingUser;
import com.isep.cooking.jsonEntities.JsonRecipe;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

@Path("recipe")
public class RecipeResource {

	RecipeDAO dao = new RecipeDAO();
	IngredientDAO ingredientDao = new IngredientDAO();

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

		Recipe recipe = dao.getRecipeById(id);
		JsonRecipe jsonRecipe = new JsonRecipe(recipe);

		return jsonRecipe;

	}

	@POST
	@Path("get/withIngredients")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonRecipe> getRecipeByIngredients(String request) {
		
		JSONObject object = new JSONObject(request);

		List<Object> objectIds
				= object.getJSONArray("ingredientIds").toList();
		
		List<String> ingredientIds = new ArrayList<>();
		
		for (Object o : objectIds) {
			ingredientIds.add(o.toString());
		}

		List<Recipe> recipes
				= dao.getRecipesByIngredients(ingredientIds);

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

		this.dao.persist(recipe);
		
	}
	
	@POST
	@Path("fromUserFridge/checkTools={boolean}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonRecipe> getRecipeByUsers(
			@PathParam("boolean") boolean checkTools, String id) {

		List<String> userIngredientsIds
				= ingredientDao.getIngredientIdsByUser(id);
		
		List<Recipe> recipes = dao.getRecipesByIngredients(userIngredientsIds);
		List<JsonRecipe> jsonRecipes = new ArrayList<>();
		
		for (Recipe r : recipes) {
			
			jsonRecipes.add(new JsonRecipe(r));
			
		}
		
		return jsonRecipes;

	}

}
