package com.example.demo.app.property;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 	
	@GetMapping("/index")
	public String index(Model model) {
		List<Property> list = propertyService.getAll();
		
		model.addAttribute("propertyList", list);
		model.addAttribute("title", "物件一覧");
		
		return "property/index";
	}
	
	@GetMapping("/form")
	public String form(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "投稿フォーム");
		return "property/form";
	}
	
	@PostMapping("/form")
	public String formGoBack(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "投稿フォーム");
		return "property/form"; 
	}
	
	@PostMapping("/confirm")
	public String confirm(@Validated PropertyForm propertyForm,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("title", "投稿フォーム");
			return "property/form";
		}
		model.addAttribute("title", "確認ページ");
		return "property/confirm";
	}
	
	@PostMapping("/complete")
	public String complete(@Validated PropertyForm propertyForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("title", "投稿フォーム");
			return "property/form";
		}
		
		Property property = new Property();
		property.setPropertyName(propertyForm.getPropertyName());
		property.setAddress(propertyForm.getAddress());
		property.setTel1(propertyForm.getTel1());
		property.setEmail(propertyForm.getEmail());
		property.setDetail1(propertyForm.getDetail1());
		property.setCreated(LocalDateTime.now());
		redirectAttributes.addFlashAttribute("complete", "登録しました！");
		
		propertyService.save(property);

		return "redirect:/property/form";
	}
	
	@GetMapping("/delete/{id}")
	public String comfirmDelete(@PathVariable("id") int id, Model model) {
		
		Property property = new Property();
		property = propertyService.comfirm(id);
		model.addAttribute("oneProperty", property);
		model.addAttribute("title", "削除しますか？");
		return "property/comfirmDelete";
	}

}
