package com.scu.hub.entity;

import java.sql.Date;

public class User {


    private String userId;
    private String  username;
    private String password;
    private Boolean gender;
    private Integer age;
    private Date birth;
    private String description;

    public User(String userId, String username, String password, Boolean gender, Integer age, Date birth, String description) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.birth = birth;
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", birth=" + birth +
                ", description='" + description + '\'' +
                '}';
    }
}
