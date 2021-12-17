package com.example.demo.app.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
    public String getLogin(Model model) {
        return "/authentication/login";
    }

    @GetMapping("/eroor")
    public String getLoginError(Model model) {
    	model.addAttribute("ErrorMessage","*ユーザー名もしくはパスワードが一致しません");
    	System.out.println("あ");
        return "/authentication/login";
    }


}