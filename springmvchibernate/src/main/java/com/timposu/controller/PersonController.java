package com.timposu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.timposu.model.Person;
import com.timposu.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String getHello(Model model) {
		List<Person> listPerson = personService.findAll();
		model.addAttribute("list", listPerson);
		return "listperson";
	}

}
