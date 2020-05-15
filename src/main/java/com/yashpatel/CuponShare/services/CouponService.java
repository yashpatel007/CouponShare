/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.services;

import com.yashpatel.CuponShare.models.Coupon;
import com.yashpatel.CuponShare.models.User;
import com.yashpatel.CuponShare.repositories.CuponRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yashpatel
 */

@Service
public class CouponService {
    
    
    
    @Autowired
    private CuponRepository couponRepo;
    
    
    
    public List<Coupon> findall(){
        return couponRepo.findAll();
    }
    
    
    public Coupon saveCoupon(Coupon coupon, User user){
          coupon.setUser(user);
          return couponRepo.save(coupon);
    }
    
    
    public List<Coupon> findByUser(User user){
    return couponRepo.findByUser(user);
    }
    
    public void deleteById(String couponId){
            couponRepo.deleteById(couponId);
            
    }
    
    public Optional<Coupon> findById(String couponId){
    
        Optional<Coupon> coupon = couponRepo.findById(couponId);
        
        return coupon;
    }
    
    
}
