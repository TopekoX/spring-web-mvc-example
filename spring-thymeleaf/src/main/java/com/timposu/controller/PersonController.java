package com.timposu.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.timposu.model.Person;

@Controller
public class PersonController {
	@GetMapping("/person/list")
	public String getPerson(Model m) {
		List<Person> persons = new ArrayList<>();
		Person p1 = new Person();
		p1.setId(1);
		p1.setNama("Ucup");
		persons.add(p1);
		Person p2 = new Person();
		p2.setId(2);
		p2.setNama("Ipul");
		persons.add(p2);
		m.addAttribute("person", persons);
		return "person/list";
	}
}