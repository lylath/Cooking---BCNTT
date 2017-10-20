package com.isep.cooking.resources;

import com.isep.cooking.dao.ToolDAO;
import com.isep.cooking.entities.Tool;
import com.isep.cooking.jsonEntities.JsonTool;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("tool")
public class ToolResource {

	ToolDAO dao = new ToolDAO();

	@GET
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<JsonTool> getTool() {

		List<Tool> tools = dao.getTool();
		List<JsonTool> jsonTools = new ArrayList<>();

		for (Tool t : tools) {

			jsonTools.add(new JsonTool(t));

		}

		return jsonTools;

	}

	@POST
	@Path("get")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JsonTool getToolById(String id) {

		UUID uuid = UUID.fromString(id);

		Tool tool = dao.getToolById(uuid);
		JsonTool jsonTool = new JsonTool(tool);

		return jsonTool;

	}

	@POST
	@Path("new")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void postCookingUser(Tool tool) {

		tool.generateId();
		this.dao.persist(tool);

	}
}
