package com.example.demo.app.property;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("title", "Property Form");
		return "property/form";
	}

}
