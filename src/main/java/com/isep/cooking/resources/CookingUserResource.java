package com.isep.cooking.resources;

import com.isep.cooking.dao.UserDAO;
import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.jsonEntities.JsonCookingUser;
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

@Path("user")
public class CookingUserResource {

	UserDAO dao = new UserDAO();

	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonCookingUser> getCookingUser() {

		List<CookingUser> cookingUser = dao.getCookingUser();
		List<JsonCookingUser> jsonCookingUsers = new ArrayList<>();

		for (CookingUser u : cookingUser) {

			jsonCookingUsers.add(new JsonCookingUser(u));

		}

		return jsonCookingUsers;

	}

	@POST
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonCookingUser getCookingUserById(String id) {

		CookingUser cookingUser = dao.getCookingUserById(id);
		JsonCookingUser jsonCookingUser = new JsonCookingUser(cookingUser);

		return jsonCookingUser;

	}

	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void postCookingUser(CookingUser cookingUser) {

		if (cookingUser.generateId()) {
			this.dao.persist(cookingUser);
		}

	}

}
