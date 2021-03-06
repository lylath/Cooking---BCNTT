package com.isep.cooking.resources;

import com.isep.cooking.dao.IngredientDAO;
import com.isep.cooking.entities.Ingredient;
import com.isep.cooking.jsonEntities.JsonIngredient;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

@Path("ingredient")
public class IngredientResource {

	IngredientDAO dao = new IngredientDAO();

	@GET
	@Path("get")
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
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonIngredient getIngredientById(String id) {

		Ingredient ingredient = dao.getIngredientById(id);
		JsonIngredient jsonIngredient = new JsonIngredient(ingredient);

		return jsonIngredient;

	}

	@POST
	@Path("get/list")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonIngredient> getIngredientByIds(String ids) {

		JSONObject object = new JSONObject(ids);

		List<Object> objectIds
				= object.getJSONArray("ingredientIds").toList();

		List<String> ingredientIds = new ArrayList<>();

		for (Object o : objectIds) {
			ingredientIds.add(o.toString());
		}

		List<Ingredient> ingredients = dao.getIngredientsById(ingredientIds);
		List<JsonIngredient> jsonIngredients = new ArrayList<>();

		for (Ingredient i : ingredients) {
			jsonIngredients.add(new JsonIngredient(i));
		}

		return jsonIngredients;

	}

	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void postIngredient(Ingredient ingredient) {

		this.dao.persist(ingredient);

	}
}
