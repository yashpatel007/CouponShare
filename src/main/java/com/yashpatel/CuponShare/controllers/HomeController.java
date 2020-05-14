/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.controllers;

import com.yashpatel.CuponShare.models.Coupon;
import com.yashpatel.CuponShare.models.User;
import com.yashpatel.CuponShare.services.CouponService;
import com.yashpatel.CuponShare.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author yashpatel
 */

@Controller
public class HomeController {
    
    
    @Autowired
    private CouponService couponService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String showHome(ModelMap model){
        model.put("coupons", couponService.findall());
        return "index";
    }
    
    @GetMapping("/login")
    public String showLogin(){
        
        return "login";
    }
    
    
    @GetMapping("/register")
    public String showRegister(ModelMap model){
        model.put("user", new User());
        return "register";
    }
    
    
    @PostMapping("/saveCoupon")
    public String saveCoupon(@ModelAttribute Coupon coupon){
        
        couponService.saveCoupon(coupon);
        return "redirect:/";
    }
    
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
    
}
