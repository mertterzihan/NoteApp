package com.globalmaksimum.noteapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.globalmaksimum.noteapp.model.repository.UserBO;

@Controller
@RequestMapping("/")
public class LoginController {

	private UserBO userRepository;

	public UserBO getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserBO userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() {

		return "login";
	}
	
	/*@RequestMapping(method = RequestMethod.POST)
	public String rejectLogin() {

		return "login";
	}*/
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "login";
 
	}
 
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "login";
 
	}
	
}
