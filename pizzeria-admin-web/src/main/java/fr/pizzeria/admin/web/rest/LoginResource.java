package fr.pizzeria.admin.web.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/login")
public class LoginResource {
	
	@Inject private TokenService tokenService;
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response login(@FormParam("email") String email, @FormParam("motDePasse") String motDePasse) {
		Response resp = null;
		if ("admin@pizzeria".equals(email) && "admin".equals(motDePasse)) {
			// cas ok
			
			// génération d'un token unique
			String token = tokenService.generateNewToken();
			resp = Response.ok(token).build();
			
		} else {
			// cas ko
			resp = Response.status(Status.FORBIDDEN).build();
		}
		return resp;	
	}
}
