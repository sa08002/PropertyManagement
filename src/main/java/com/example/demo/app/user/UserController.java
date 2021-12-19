package com.example.demo.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.UserDetailsServiceImpl;

@Controller
public class UserController {
	
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

	@GetMapping("/login")
    public String getLogin() {
        return "/user/login";
    }

    @GetMapping("/login-error")
    public String getLoginError(Model model) {
    	model.addAttribute("ErrorMessage","ユーザー名もしくはパスワードが一致しません");
        return "/user/login";
    }
    
    @GetMapping("/signup")
    public String newSignup(SignupForm signupForm) {
        return "/user/signup";
    }
    
    @PostMapping("/signup")
    public String signup(SignupForm signupForm, Model model) {
        try {
            userDetailsServiceImpl.register(signupForm.getEmployee(), signupForm.getUsername(), signupForm.getPassword(), "ROLE_USER");
        } catch (DataAccessException e) {
            model.addAttribute("signupError", "ユーザー登録に失敗しました");
            return "user/signup";
        }
        return "redirect:property/index";
    }


}