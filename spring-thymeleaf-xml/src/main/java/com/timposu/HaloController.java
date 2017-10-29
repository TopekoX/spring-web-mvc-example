package com.timposu;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HaloController {
	
	@GetMapping("/")
	public String halo(ModelMap mm) {
		System.out.println("Menjalankan method halo");
		mm.addAttribute("waktu", new Date());
		return "halo";
	}

}
