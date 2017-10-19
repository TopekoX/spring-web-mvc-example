package com.timposu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HaloController {

	@GetMapping("/")
	public String sayHalo(Model model) {
		model.addAttribute("pesan","Halo Dunia...");
		return "halo";
	}
}
