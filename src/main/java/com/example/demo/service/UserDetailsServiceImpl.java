package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.app.user.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
//  パスワードのハッシュ化
    @Autowired
    PasswordEncoder passwordEncoder;

//  ログイン認証
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            String sql = "SELECT * FROM user WHERE name = ?";
            Map<String, Object> map = jdbcTemplate.queryForMap(sql, username);
            int id = (int)map.get("id");
            String employee = (String)map.get("employee");
            String password = (String)map.get("password");
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority((String)map.get("authority")));
            return new UserDetailsImpl(id, employee, username, password, authorities);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user not found.", e);
        }
    }
    
//  ユーザー登録
    @Transactional
    public void register(String employee, String username, String password, String authority) {
        String sql = "INSERT INTO user(employee, name, password, authority) VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee, username, passwordEncoder.encode(password), authority);
    }
    
//  ユーザ一覧
	public List<UserDetailsImpl> getAll() {
		String sql = "SELECT id, employee, name, password, authority FROM user";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<UserDetailsImpl> list = new ArrayList<UserDetailsImpl>();
		for(Map<String, Object> result : resultList) {
			UserDetailsImpl userDetailImpl = new UserDetailsImpl();
			userDetailImpl.setId((int)result.get("id"));
			userDetailImpl.setEmployee((String)result.get("employee"));			
			userDetailImpl.setUsername((String)result.get("name"));
			userDetailImpl.setPassword((String)result.get("password"));
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority((String)result.get("authority")));
			userDetailImpl.setAuthorities(authorities);
			list.add(userDetailImpl);
		}
		return list;
	}
    
}