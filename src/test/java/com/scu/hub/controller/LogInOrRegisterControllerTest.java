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
public class LogInOrRegisterControllerTest {

    private static final String url = "/";
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void loginPage() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post(url+"/login/page")).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void register() throws Exception {
        String userId = "userfdsaf1";
        String username = "userjjname";
        String password = "123456";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userId", userId);
        params.add("username", username);
        params.add("password", password);


        MvcResult mvcResult = mockMvc.perform(post(url+"/register/information").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void verifyUser() throws Exception {

    }

    @Test
    public void personalInfoPage() throws Exception {

    }
}