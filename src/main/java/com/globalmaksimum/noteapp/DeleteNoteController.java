package com.globalmaksimum.noteapp;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteBO;
import com.sun.jersey.api.view.Viewable;

@Path("/delete")
public class DeleteNoteController {

	private NoteBO noteRepository;

	@POST
	public Response addNewEvent(@FormParam("note") String id) {
		
		if(id==null){
			return Response.status(200).entity(new Viewable("/")).build();
		}
		
		noteRepository.deleteNote(new Integer(id));

		return Response.status(200).entity(new Viewable("/")).build();
	}
	
	@GET
	public Response deleteEvent() {

		List<Note> list = noteRepository.retrieveNotes();

		return Response.status(200).entity(new Viewable("/delete", list)).build();
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}

}
