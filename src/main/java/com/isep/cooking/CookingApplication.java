package com.isep.cooking;

import com.isep.cooking.resources.CookingUserResource;
import com.isep.cooking.resources.IngredientResource;
import com.isep.cooking.resources.PictureResource;
import com.isep.cooking.resources.RecipeResource;
import com.isep.cooking.resources.ToolResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class CookingApplication extends Application<CookingConfiguration> {

	public static void main(String[] args) throws Exception {

		new CookingApplication().run(args);

	}

	@Override
	public void run(CookingConfiguration t, Environment e) {

		RecipeResource recipeResource = new RecipeResource();
		CookingUserResource userResource = new CookingUserResource();
		ToolResource toolResource = new ToolResource();
		IngredientResource ingredientResource = new IngredientResource();
		PictureResource pictureResource = new PictureResource();
		e.jersey().register(pictureResource);
		e.jersey().register(recipeResource);
		e.jersey().register(userResource);
		e.jersey().register(toolResource);
		e.jersey().register(ingredientResource);

	}

}
