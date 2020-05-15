/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yashpatel.CuponShare.models;

import javax.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author yashpatel
 */


@Document
public class Coupon {
    
    @Id
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private String code;
    
    private String buttonText;
    private String buttonUrl;
    
    @DBRef
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

     public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl;
    }

    @Override
    public String toString() {
        return "Coupon{" + "id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl + ", code=" + code + ", buttonText=" + buttonText + ", buttonUrl=" + buttonUrl + ", user=" + user + '}';
    }
    
    
    
    
}
