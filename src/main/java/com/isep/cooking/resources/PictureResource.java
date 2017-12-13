package com.isep.cooking.resources;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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

		if (uuid.contains("/")||uuid.contains("\\")||uuid.contains(".")) {
			return Response.serverError().build();
		}
		
		BufferedImage bi = ImageIO.read(
				new File("src/main/resources/pictures/" + uuid + ".png"));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bi, "png", baos);
		byte[] imageData = baos.toByteArray();

		return Response.ok(imageData).build();


	}

}
