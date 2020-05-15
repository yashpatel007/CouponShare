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
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    
    
    @GetMapping("/id/{couponId}")
    public String showEditproduct(ModelMap model,@PathVariable("couponId") String couponId) throws NoSuchElementException{
        
        Optional<Coupon> coupon = couponService.findById(couponId);
        if(coupon.isPresent()) model.put("coupon", couponService.findById(couponId).get());
        
        return "editCoupon";
    }
    
    
    @PostMapping("/id/{couponId}")
    public String updateCoupon(@AuthenticationPrincipal User user,@ModelAttribute Coupon coupon,@PathVariable("couponId") String couponId){
        coupon.setId(couponId);
        couponService.saveCoupon(coupon, user);
        return "redirect:/myCoupons";
    }
    
    
    @GetMapping("/")
    public String showHome(ModelMap model, @AuthenticationPrincipal User user){
        model.put("coupons", couponService.findall());
        model.put("coupons", couponService.findall());
        if(user!=null) model.put("user", user);
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
    
    @GetMapping("/dashboard")
    public String showDashBoard(ModelMap model,@AuthenticationPrincipal User user){
        model.put("user", user);
        return "redirect:/";
    }
    
    @GetMapping("/newCoupon")
    public String showNewCoupon(ModelMap model,@AuthenticationPrincipal User user){
        model.put("user", user);
        return "createCoupon";
    }
    
    @GetMapping("/myCoupons")
    public String showMyCoupons(ModelMap model,@AuthenticationPrincipal User user){
    model.put("user", user);
    model.put("onMyCoupons",true);
    model.put("coupons",couponService.findByUser(user));
    return "mycoupons";
    }
    
    
    @PostMapping("/newCoupon")
    public String saveCoupon(@AuthenticationPrincipal User user,@ModelAttribute Coupon coupon){
        
        if(user==null) return "redirect:/login";
        
        couponService.saveCoupon(coupon, user);
        return "redirect:/myCoupons";
    }
    
    @PostMapping("/register")
    public String saveUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/login";
    }
    
    
    
    @PostMapping("/deleteCoupon")
    public String deleteCoupon(@ModelAttribute("couponId") String couponId ){
        
        couponService.deleteById(couponId);
        return "redirect:/myCoupons";
    }
    
    
    
}
