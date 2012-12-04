package com.globalmaksimum.noteapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.globalmaksimum.noteapp.model.repository.NoteBO;
import com.sun.jersey.api.view.Viewable;

@Path("/new")
public class NewNoteController {

	private NoteBO noteRepository;

	@POST
	public Response addNewEvent(@FormParam("note") String Note,
			@FormParam("datepicker") String Date,
			@FormParam("priority") String Priority)
			throws ParseException {

		if(!Date.matches("\\d{2}/\\d{2}/\\d{4}")){
			return Response.status(200).entity(new Viewable("/")).build();
		}
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = format.parse(Date);

		noteRepository.insertNewNode(Note, date, Priority);

		return Response.status(200).entity(new Viewable("/")).build();
	}
	
	@GET
	public Response newEvent() {

		return Response.status(200).entity(new Viewable("/new")).build();
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}
}
