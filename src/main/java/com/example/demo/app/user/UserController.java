package com.example.demo.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserDetailsServiceImpl;


@Controller
@RequestMapping(value = { "/user", "" })
public class UserController {
	
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

//  ログイン画面
	@GetMapping("/login")
    public String getLogin() {
        return "/user/login";
    }

//	ログイン時エラー発生
    @GetMapping("/login-error")
    public String getLoginError(Model model) {
    	model.addAttribute("ErrorMessage","ユーザー名もしくはパスワードが一致しません");
        return "/user/login";
    }
    
//  新規登録画面
    @GetMapping("/signup")
    public String newSignup(SignupForm signupForm) {
        return "/user/signup";
    }
    
//  新規登録処理
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