package com.scu.hub.entity;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class UserTest {

    User user;
    @Before
    private void before(){
        user = new User("user123", "namename", "123456", true, 11, new Date(2000, 01, 01), "dedde");
    }

    @Test
    public void getUserId() {
        System.out.println(user.getUserId());
    }

    @Test
    public void setUserId() {
        user.setUserId("11");
    }

    @Test
    public void getUsername() {
        System.out.println(user.getUsername());
    }

    @Test
    public void setUsername() {
        user.setUsername("11");
    }

    @Test
    public void getPassword() {
        System.out.println(user.getPassword());
    }

    @Test
    public void setPassword() {
        user.setPassword("11");
    }

    @Test
    public void getGender() {
        System.out.println(user.getGender());
    }

    @Test
    public void setGender() {
        user.setGender(false);
    }

    @Test
    public void getAge() {
        System.out.println(user.getAge());
    }

    @Test
    public void setAge() {
        user.setAge(11);
    }

    @Test
    public void getBirth() {
        System.out.println(user.getBirth());
    }

    @Test
    public void setBirth() {
        user.setBirth(new Date(2000, 01, 01));
    }

    @Test
    public void getDescription() {
        System.out.println(user.getDescription());
    }

    @Test
    public void setDescription() {
        user.setDescription("14512334");
    }
}