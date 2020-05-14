/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.repositories;

import com.yashpatel.CuponShare.models.Authority;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author yashpatel
 */
public interface AuthorityRepository extends MongoRepository<Authority, String> {
        List<Authority> findByAuthority(String authority);
}
