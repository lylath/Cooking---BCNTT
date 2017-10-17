package com.isep.cooking.resources;

import com.isep.cooking.dao.IngredientDAO;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.jsonEntities.JsonIngredient;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ingredient")
public class IngredientResource {

	IngredientDAO dao = new IngredientDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonIngredient> getIngredient() {

		List<Ingredient> ingredients = dao.getIngredient();
		List<JsonIngredient> jsonIngredients = new ArrayList<>();

		for (Ingredient i : ingredients) {

			jsonIngredients.add(new JsonIngredient(i));

		}

		return jsonIngredients;

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonIngredient getIngredientById(String id) {

		UUID uuid = UUID.fromString(id);

		Ingredient ingredient = dao.getIngredientById(uuid);
		JsonIngredient jsonIngredient = new JsonIngredient(ingredient);

		return jsonIngredient;

	}
}
