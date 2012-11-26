package com.globalmaksimum.noteapp;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalmaksimum.noteapp.model.repository.NoteBO;

@Controller
@RequestMapping("/delete")
public class DeleteNoteController {

	private NoteBO noteRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String addNewEvent(@RequestParam("note") String id, Model model)
			throws SQLException, ClassNotFoundException {

		noteRepository.deleteNote(id);

		return "redirect:/home";
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}

}
