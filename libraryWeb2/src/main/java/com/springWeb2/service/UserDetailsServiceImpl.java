package com.springWeb2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springWeb2.entity.BookDao;
import com.springWeb2.entity.User;
import com.springWeb2.repository.UserRepository;
import com.springWeb2.security.CustomUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    
    public void saveUser(User user) {
        String password =  passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setEnabled(true);
         this.userRepository.save(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepository.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Could not find User");
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return  customUserDetails;
    }
}
