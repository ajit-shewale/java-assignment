package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.security.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByusername(username);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		
		return new UserPrincipal(user);
	}
}
