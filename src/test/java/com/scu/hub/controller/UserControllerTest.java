package com.scu.hub.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    private static final String url = "/user";
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void getAllUser() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post(url+"/allUser")).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getUserById() throws Exception {
        String userId = "user1";
        MvcResult mvcResult = mockMvc.perform(post(url + "/getUserById").param("userId", userId))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getUserByName() throws Exception {
        String username = "2";
        MvcResult mvcResult = mockMvc.perform(post(url + "/getUserByName").param("username", username))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void updateUserName() throws Exception {
        String username = "user1_new_name";
        String userId = "user1";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", username);
        params.add("userId", userId);
        MvcResult mvcResult = mockMvc.perform(post(url + "/updateUserName").params(params))
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
}