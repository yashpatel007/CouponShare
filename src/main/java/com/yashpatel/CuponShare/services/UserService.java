/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.services;

import com.yashpatel.CuponShare.models.Authority;
import com.yashpatel.CuponShare.models.User;
import com.yashpatel.CuponShare.repositories.AuthorityRepository;
import com.yashpatel.CuponShare.repositories.UserRepository;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author yashpatel
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Autowired
    private AuthorityRepository authorityRepo;
   
    
    public List<User> findall(){
        return userRepo.findAll();
    }
    
    public User saveUser(User user){
       
       
       String encodedPass = passwordEncoder.encode(user.getPassword());
       user.setPassword(encodedPass);  
       
        //System.out.println(authorityRepo.findByAuthority("ROLE_USER").get(0));
       user.getAuthorities().add(authorityRepo.findByAuthority("ROLE_USER").get(0));
       
       
       return userRepo.save(user);
       
    }
    
}
