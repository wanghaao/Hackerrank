package com.scu.hub.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void getAllUser() {
        System.out.println(userMapper.getAllUser());
    }

    @Test
    public void getUserById() {
        System.out.println(userMapper.getUserById("user1"));
    }

    @Test
    public void getUserByName() {
        System.out.println(userMapper.getUserByName("aaa"));
    }

    @Test
    public void insertUser() {
        System.out.println(userMapper.insertUser("uid1", "namename", "12341234"));
    }

    @Test
    public void updateUserName() {
        System.out.println(userMapper.updateUserName("nanameme", "user1"));
    }
}