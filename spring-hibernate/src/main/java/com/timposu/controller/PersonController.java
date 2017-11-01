package com.timposu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.timposu.model.Person;
import com.timposu.service.PersonService;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@GetMapping("/")
	public String getList(Model model) {
		List<Person> listPerson = personService.findAll();
		model.addAttribute("list", listPerson);
		return "list";
	}
	
	@GetMapping("/tambah")
	public String formPerson(@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		model.addAttribute("person", new Person());
		
		if (id != null) {
			Person p = personService.findOne(id);
			if (p != null) {
				model.addAttribute("person", p);
			}
		}
		return "tambah";
	}
	
	@PostMapping("/tambah")
	public String processForm(@Valid @ModelAttribute Person person, 
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/tambah";
		}
		personService.save(person);
		return "redirect:/";
	}

	@GetMapping("/hapus")
	public String delete(@RequestParam Integer id) {
		personService.delete(id);
		return "redirect:/";
	}
}
