package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bean.User;

public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        System.out.println("enabled db="+user.isEnabled());
        boolean isEnabled = user.isEnabled();
        if(isEnabled==false)
        {
        	throw new UsernameNotFoundException("User Not Activated please contact to admin");
        	
        }
        
        return new MyUserDetails(user);
    }
 
}