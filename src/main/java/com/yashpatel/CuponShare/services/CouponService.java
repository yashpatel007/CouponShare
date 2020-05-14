/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.services;

import com.yashpatel.CuponShare.models.Coupon;
import com.yashpatel.CuponShare.repositories.CuponRepository;
import java.util.List;
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
    
    
    public Coupon saveCoupon(Coupon coupon){
          return couponRepo.save(coupon);
    }
    
    
    
    
}
