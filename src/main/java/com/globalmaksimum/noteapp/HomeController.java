package com.globalmaksimum.noteapp;

import java.security.Principal;
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
@RequestMapping("/home")
public class HomeController {

	private NoteBO noteRepository;

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Model model, Principal principal) {

		String name = principal.getName();
		List<Note> instances = noteRepository.retrieveNotes(name);
		if(instances != null)
			model.addAttribute("it", instances);

		return "home";
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String logout() {

			return "redirect:/";
	}

}
