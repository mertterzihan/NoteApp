package com.globalmaksimum.noteapp;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteBO;
import com.sun.jersey.api.view.Viewable;

/**
 * Handles requests for the application home page.
 */
@Path("/home")
public class HomeController {

	private NoteBO noteRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@GET
	public Response home() {

		List<Note> instances = noteRepository.retrieveNotes();

		return Response.status(200).entity(new Viewable("/home", instances)).build();
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}
	
	@POST
	public Response logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		
		try {
			return Response.temporaryRedirect(new URI("/")).build();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(200).entity(new Viewable("/")).build();
		}
	}

}
