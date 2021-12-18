package com.example.demo.app.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

	@GetMapping("/login")
    public String getLogin() {
        return "/authentication/login";
    }

    @GetMapping("/login-error")
    public String getLoginError(Model model) {
    	model.addAttribute("ErrorMessage","ユーザー名もしくはパスワードが一致しません");
        return "/authentication/login";
    }


}