/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.configurations;

import com.yashpatel.CuponShare.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author yashpatel
 */

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
   
     @Bean
     public PasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
     }
     
     @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//      auth.userDetailsService(userDetailsService)
//                .passwordEncoder(getPasswordEncoder());
       auth.inMemoryAuthentication()
                .passwordEncoder(getPasswordEncoder())
                .withUser("patelyash1311@gmail.com")
                .password("asdf")
                .roles("USER");
      
         
      }
     
      @Override
      protected void configure(HttpSecurity http) throws Exception {
                    http  
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/register").permitAll()
                    .anyRequest().hasRole("USER").and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/dashboard")
                    .permitAll()
                    .and()
                    .logout().logoutUrl("/logout")
                    .permitAll(); 
                    
    }
}
