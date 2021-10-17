package com.example.demo.app.property;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/property")
public class PropertyController {
	
	@GetMapping("/form")
	public String form(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "Property Form");
		return "property/form";
	}
	
	@PostMapping("/confirm")
	public String confirm(@Validated PropertyForm propertyForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "Property Form");
			return "property/form";
		}
		model.addAttribute("title", "Confirm Page");
		return "property/confirm";
	}

}
