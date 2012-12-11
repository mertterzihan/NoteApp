package com.globalmaksimum.noteapp;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalmaksimum.noteapp.model.repository.NoteBO;

@Controller
@RequestMapping("/home/new")
public class NewNoteController {

	private NoteBO noteRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String addNewEvent(@RequestParam("note") String Note,
			@RequestParam("datepicker") String Date,
			@RequestParam("priority") String Priority, Model model, Principal principal)
			throws ParseException {

		if(!Date.matches("\\d{2}/\\d{2}/\\d{4}")){
			return "redirect:/home";
		}
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = format.parse(Date);
		
		String name = principal.getName();

		noteRepository.insertNewNode(Note, date, Priority, name);

		return "redirect:/home";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String newEvent() {

		return "new";
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}
}
