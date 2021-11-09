package com.example.demo.app.property;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Property;
import com.example.demo.service.PropertyService;

@Controller
@RequestMapping("/property")
public class PropertyController {
	
	private final PropertyService propertyService;

	
 	@Autowired
 	public PropertyController(PropertyService propertyService){
 		this.propertyService = propertyService;
 	}
	
	@GetMapping("/form")
	public String form(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "Property Form");
		return "property/form";
	}
	
	@PostMapping("/form")
	public String formGoBack(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "Inquiry Form");
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
	
	@PostMapping("/complete")
	public String complete(@Validated PropertyForm propertyForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("title", "roperty Form");
			return "property/form";
		}
		
		Property property = new Property();
		property.setPropertyName(propertyForm.getPropertyName());
		property.setAddress(propertyForm.getAddress());
		property.setTel1(propertyForm.getTel1());
		property.setEmail(propertyForm.getEmail());
		property.setDetail1(propertyForm.getDetail1());
		property.setCreated(LocalDateTime.now());
		redirectAttributes.addFlashAttribute("complete", "Registered!");
		
		propertyService.save(property);

		return "redirect:/property/form";
	}
	
	

}
