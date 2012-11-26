package com.globalmaksimum.noteapp;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteBO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private NoteBO noteRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@RequestMapping(value = { "/", "home" })
	public String home(Model model) throws SQLException, ClassNotFoundException {

		List<Note> list = noteRepository.retrieveNotes();
		model.addAttribute("instances", list);

		return "home";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newEvent() {

		return "new";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteEvent(Model model) throws SQLException,
			ClassNotFoundException {

		List<Note> list = noteRepository.retrieveNotes();
		model.addAttribute("instances", list);

		return "delete";
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}

}
