package com.globalmaksimum.noteapp;

import java.security.Principal;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.globalmaksimum.noteapp.model.Note;
import com.globalmaksimum.noteapp.model.repository.NoteBO;

@Controller
@RequestMapping("/home/delete")
public class DeleteNoteController {

	private NoteBO noteRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String addNewEvent(@RequestParam("note") String id, Model model, Principal principal) {
		
		if(id==null){
			return "redirect:/home";
		}
		
		String name = principal.getName();
		noteRepository.deleteNote(new Integer(id), name);

		return "redirect:/home";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String deleteEvent(Model model, Principal principal) {

		String name = principal.getName();
		List<Note> list = noteRepository.retrieveNotes(name);
		if(list != null)
			model.addAttribute("it", list);
		
		return "delete";
	}

	public NoteBO getNoteRepository() {
		return noteRepository;
	}

	public void setNoteRepository(NoteBO noteRepository) {
		this.noteRepository = noteRepository;
	}

}
