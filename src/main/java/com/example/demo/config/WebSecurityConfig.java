package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        		.antMatchers("/images/**","/css/**","/js/**","/h2-console/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
//		ログインしてなくても遷移できるリクエスト
		.antMatchers("/user/login").permitAll()//1
		.anyRequest().authenticated();//2
    
	http.formLogin()//3
//		ログインページのリクエスト先
		.loginPage("/user/login")
		.usernameParameter("username")
		.passwordParameter("password")
//		ログイン後の遷移先
		.defaultSuccessUrl("/property/index", true)
//		エラー発生時のリクエスト先
    	.failureUrl("/user/login-error")
    	.permitAll();
    http.logout()
    	.permitAll();
    
    http.headers().frameOptions().disable();
    
    http.csrf().ignoringAntMatchers("/h2-console/**");
    
    }
    
    
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//        .withUser("user")
//        .password(passwordEncoder().encode("pass"))
//        .roles("USER");
//        System.out.println(new BCryptPasswordEncoder().encode("pass"));
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}