/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.security;

import com.yashpatel.CuponShare.models.User;
import com.yashpatel.CuponShare.repositories.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author yashpatel
 */

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        
    if(user == null) {
      throw  new UsernameNotFoundException("user not found");
    }
        System.out.println("com.yashpatel.CuponShare.security.UserDetailsServiceImpl.loadUserByUsername()");
       
        return user;
        
    }
    
}
