package com.isep.cooking.resources;

import com.isep.cooking.dao.UserDAO;
import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.jsonEntities.JsonCookingUser;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
import org.apache.commons.codec.digest.DigestUtils;

@Path("user")
public class CookingUserResource {

	private UserDAO dao = new UserDAO();
	private MessageDigest md;

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
	public String postCookingUser(CookingUser cookingUser)
			throws NoSuchAlgorithmException {

		String sessionId = "";
		
		if (cookingUser.generateId()) {
			
			cookingUser.setPassword(
					new String(DigestUtils.sha512(cookingUser.getPassword()))
			);
			
			this.dao.persist(cookingUser);
			
			CookingUser user = this.dao.getUserByMail(cookingUser.getEmail());
			
			sessionId = this.dao.generateSessionId(user);
			
		}
		
		return sessionId;

	}

	@POST
	@Path("authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String authenticateCookingUser(CookingUser cookingUser)
			throws NoSuchAlgorithmException {

		String hashedPass =
				new String(DigestUtils.sha512(cookingUser.getPassword()));
		
		CookingUser dbUser = this.dao.getUserByMail(cookingUser.getEmail());
		
		if (dbUser.getPassword().equals(hashedPass)) {
			
			return this.dao.generateSessionId(dbUser);
			
		}
		
		return "";

	}
//								Really needed? (probably not)
//	@POST
//	@Path("authenticate/token")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public String authenticateCookingUserWithToken(String token)
//			throws NoSuchAlgorithmException {
//
//		String hashedPass =
//				new String(DigestUtils.sha512(cookingUser.getPassword()));
//		
//		CookingUser dbUser = this.dao.getUserByMail(cookingUser.getEmail());
//		
//		if (dbUser.getPassword().equals(hashedPass)) {
//			
//			return this.dao.generateSessionId(dbUser);
//			
//		}
//		
//		return "";
//
//	}
	
	

}
