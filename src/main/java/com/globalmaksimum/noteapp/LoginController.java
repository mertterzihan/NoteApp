package com.globalmaksimum.noteapp;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.globalmaksimum.noteapp.model.repository.UserBO;
import com.sun.jersey.api.view.Viewable;

@Path("/")
public class LoginController {

	private UserBO userRepository;

	public UserBO getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserBO userRepository) {
		this.userRepository = userRepository;
	}
	
	@GET
	public Response login() {

		return Response.status(200).entity(new Viewable("/login")).build();
	}
	
	@POST
	public Response rejectLogin() {

		return Response.status(200).entity(new Viewable("/login")).build();
	}
	
}
