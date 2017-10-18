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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("user")
public class CookingUserResource {

	UserDAO dao = new UserDAO();

	@GET
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
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonCookingUser getCookingUserById(String id) {

		UUID uuid = UUID.fromString(id);
		
		CookingUser cookingUser = dao.getCookingUserById(uuid);
		JsonCookingUser jsonCookingUser = new JsonCookingUser(cookingUser);

		return jsonCookingUser;

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void postCookingUser(CookingUser cookingUser) {

		this.dao.persist(cookingUser);
		
	}
	
}
