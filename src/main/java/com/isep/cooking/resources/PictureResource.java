package com.isep.cooking.resources;

import com.isep.cooking.entities.CookingUser;
import com.isep.cooking.jsonEntities.JsonCookingUser;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("picture")
public class PictureResource {

	@GET
	@Path("{uuid}")
	@Produces("image/png")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getCookingUser(@PathParam("uuid") String uuid)
			throws IOException {

		BufferedImage bi = ImageIO.read(
				new File("src/main/resources/images/" + uuid + ".png"));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bi, "png", baos);
		byte[] imageData = baos.toByteArray();

		return Response.ok(imageData).build();


	}

}
