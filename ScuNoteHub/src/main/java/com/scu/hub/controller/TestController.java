package com.scu.hub.controller;

import com.scu.hub.service.TestService;
import com.scu.hub.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController{
    @Resource
    TestService service;

    @RequestMapping("/index")
    @ResponseBody
    public List<User> getUser(){
        return service.getallUser();
    }
}


