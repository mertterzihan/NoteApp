package com.globalmaksimum.noteapp;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalmaksimum.noteapp.model.NoteRepository;

@Controller
@RequestMapping("/delete")
public class DeleteNoteController {

	private NoteRepository noteRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String addNewEvent(@RequestParam("note") String id, Model model)
			throws SQLException, ClassNotFoundException {

		noteRepository.deleteNote(id);

		return "redirect:/home";
	}

	public NoteRepository getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteRepository noteRepository) {
		this.noteRepository = noteRepository;
	}

}
