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

import com.example.demo.entity.Detail;
import com.example.demo.entity.Property;
import com.example.demo.service.DetailService;
import com.example.demo.service.PropertyService;

@Controller
@RequestMapping("/property")
public class PropertyController {
	
	private final PropertyService propertyService;
	private final DetailService detailService;

	
 	@Autowired
 	public PropertyController(PropertyService propertyService, DetailService detailService){
 		this.propertyService = propertyService;
 		this.detailService =detailService;
 	}
 	
	
//	投稿フォーム
	@GetMapping("/form")
	public String form(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "投稿フォーム");
		return "property/form_boot";
	}
	
//	投稿フォームから戻る処理
	@PostMapping("/form")
	public String formGoBack(PropertyForm propertyForm, Model model) {
		model.addAttribute("title", "投稿フォーム");
		return "property/form_boot"; 
	}
	
//	投稿
	@PostMapping("/confirm")
	public String confirm(@Validated PropertyForm propertyForm,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "投稿フォーム");
			return "property/form_boot";
		}
		model.addAttribute("title", "確認ページ");
		return "property/confirm_boot";
	}
	
//	投稿処理
	@PostMapping("/complete")
	public String complete(@Validated PropertyForm propertyForm,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "投稿フォーム");
			return "property/form_boot";
		}
		
		Property property = new Property();
		Detail detail = new Detail();
		property.setId(propertyForm.getId());
		property.setPropertyName(propertyForm.getPropertyName());
		property.setAddress(propertyForm.getAddress());
		property.setTel1(propertyForm.getTel1());
		property.setEmail(propertyForm.getEmail());
		detail.setDetail1(propertyForm.getDetail1());
		detail.setDetail2(propertyForm.getDetail2());
		detail.setDetail3(propertyForm.getDetail3());
		detail.setDetail4(propertyForm.getDetail4());
		detail.setDetail5(propertyForm.getDetail5());
		
		switch(property.getId()) {
		case 0:
			property.setCreated(LocalDateTime.now());
			model.addAttribute("title", "登録しました！");
			propertyService.save(property);	
			break;
		default:
			model.addAttribute("title", "変更しました！");
			propertyService.update(property);
			detailService.update(detail, property.getId());
		}
		return "/property/completion";
	}
	
// 	一覧表示
	@GetMapping("/index")
	public String index(Model model) {
		List<Property> list = propertyService.getAll();
		
		model.addAttribute("propertyList", list);
		model.addAttribute("title", "物件一覧");
		
		return "property/index_boot";
	}
	
//	詳細画面
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model) {
		Property property = new Property();
		property = propertyService.confirm(id);
		Detail detail = new Detail();
		detail = detailService.confirm(id);
		model.addAttribute("oneProperty", property);
		model.addAttribute("oneDetail", detail);
		model.addAttribute("title", "物件詳細");
		return "property/detail_boot";
	}
	
//	編集画面処理
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, PropertyForm propertyForm, Model model) {
		Property property = new Property();
		property = propertyService.confirm(id);
		Detail detail = new Detail();
		detail = detailService.confirm(id);
		propertyForm.setId(id);
		propertyForm.setPropertyName(property.getPropertyName());
		propertyForm.setAddress(property.getAddress());
		propertyForm.setTel1(property.getTel1());
		propertyForm.setEmail(property.getEmail());
		propertyForm.setDetail1(detail.getDetail1());
		propertyForm.setDetail2(detail.getDetail2());
		propertyForm.setDetail3(detail.getDetail3());
		propertyForm.setDetail4(detail.getDetail4());
		propertyForm.setDetail5(detail.getDetail5());

		model.addAttribute("title", "投稿フォーム");
		return "property/form_boot"; 
	}
	
//	削除確認
	@GetMapping("/delete/{id}")
	public String confirmDelete(@PathVariable("id") int id, Model model) {
		Property property = new Property();
		property = propertyService.confirm(id);
		model.addAttribute("oneProperty", property);
		model.addAttribute("title", "削除しますか？");
		return "property/confirmDetail_boot";
	}
	
//	削除完了
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		propertyService.delete(id);
		model.addAttribute("title", "削除しました");
		return "property/completion";
	}

}
