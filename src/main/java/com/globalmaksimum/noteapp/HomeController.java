package com.globalmaksimum.noteapp;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteBO;
import com.sun.jersey.api.view.Viewable;

/**
 * Handles requests for the application home page.
 */
@Path("/")
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

}
