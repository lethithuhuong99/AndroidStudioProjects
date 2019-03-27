package com.example.contacts;

import java.io.Serializable;
import java.util.Date;

public class Contact implements Serializable {
    private String fullName;
    private String company;
    private String title;
    private String mobile;
    private String email;
    private String createdAt;
    private String avatar;
    private int mId;

    public Contact(){}

    public Contact(int mId, String fullName, String company, String title, String mobile, String email) {
        this.mId= mId;
        this.fullName = fullName;
        this.company = company;
        this.title = title;
        this.mobile = mobile;
        this.email = email;
        this.createdAt = createdAt;
        this.avatar = avatar;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
