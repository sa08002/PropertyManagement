package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurityを利用するための設定クラス
 * ログイン処理でのパラメータ、画面遷移や認証処理でのデータアクセス先を設定する
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	private MyUserService userService;
//	
//    @Autowired
//    public WebSecurityConfig (MyUserService userService) {
//        this.userService = userService;
//    }
    /**
     * 認可設定を無視するリクエストを設定
     * 静的リソース(image,javascript,css)を認可処理の対象から除外する
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
        		.antMatchers("/resources/**");
        		
	/**
	* その他の例
	* .antMatchers("/images/**")
        * .antMatchers("/css/**")
        * .antMatchers("/javascript/**")
        * .antMatchers("/js/**")
	*　,で繋げて連続で書くことも可能
	*　.antMatchers("/images/**","/css/**");
	*/
    }
    
    /**
     * 認証・認可の情報を設定する
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
		.antMatchers("/login").permitAll()//1
		.anyRequest().authenticated();//2
    
	http.formLogin()//3
		.loginPage("/login")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/property/index", true)
    	.failureUrl("/eroor")
    	.permitAll();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //ユーザー名「user」、パスワード「pass」が入力されたらログイン可能とする
        //パスワードエンコーダーを利用しないようにするため、パスワードの先頭に{noop}を
        //指定している
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}pass").roles("USER");
    }
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }
// 
//    // パスワードハッシュ化する
//    public BCryptPasswordEncoder passwordEncoder() {
//        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//            return bcpe;
//    }
}