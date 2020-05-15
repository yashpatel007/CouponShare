/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.repositories;

import com.yashpatel.CuponShare.models.Coupon;
import com.yashpatel.CuponShare.models.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yashpatel
 */

@Repository
public interface CuponRepository extends MongoRepository<Coupon,String> {
    List<Coupon> findByUser(User user);

    @Override
    public void deleteById(String id);
   
    @Override
    Optional<Coupon> findById(String id);
    
}
