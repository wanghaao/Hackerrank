package com.scu.hub.controller;

import com.scu.hub.entity.User;
import com.scu.hub.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping("/allUser")
    private List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @PostMapping("/getUserById")
    private User getUserById(@RequestParam("userId") String userId) {
        return userMapper.getUserById(userId);
    }

    @PostMapping("/getUserByName")
    private List<User> getUserByName(@RequestParam("username") String username) {
        return userMapper.getUserByName(username);
    }

    @PostMapping("/updateUserName")
    private Integer updateUserName(@RequestParam("username") String username,
                                   @RequestParam("userId") String userId) {
        return userMapper.updateUserName(username, userId);
    }
}
