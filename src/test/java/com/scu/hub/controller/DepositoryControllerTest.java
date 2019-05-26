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
public class DepositoryControllerTest {

    private static final String url = "/depository";
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void createDepository() throws  Exception {
        String depositoryName = "newDepoName";
        String depositoryOwnerId = "user1";
        String depositoryVisible = "1";
        String depositoryClassificationId = "1";
        String tags = "tag1;tag2;";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("depositoryName", depositoryName);
        params.add("depositoryOwnerId", depositoryOwnerId);
        params.add("depositoryVisible", depositoryVisible);
        params.add("depositoryClassificationId", depositoryClassificationId);
        params.add("tags", tags);

        MvcResult mvcResult = mockMvc.perform(post(url+"/create").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void keywordMatching() throws  Exception {
        String keyword = "ep";
        MvcResult mvcResult = mockMvc.perform(post(url+"/keywordMatching").param("keyword", keyword)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void addDepositoryManager() throws  Exception {
        String userId = "user1";
        String depositoryId = "7";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userId", userId);
        params.add("depositoryId", depositoryId);

        MvcResult mvcResult = mockMvc.perform(post(url+"/addDepositoryManager").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void getDepositoryById() throws  Exception {
        String depositoryId = "7";
        MvcResult mvcResult = mockMvc.perform(post(url+"/getDepositoryById").param("depositoryId", depositoryId)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void setVisibleById() throws  Exception {
        String visible = "true";
        String depositoryId = "7";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("visible", visible);
        params.add("depositoryId", depositoryId);

        MvcResult mvcResult = mockMvc.perform(post(url+"/setVisibleById").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void depositoryLike() throws  Exception {
        String depositoryId = "7";
        String userId = "user1";
        String thumbsUp = "true";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("depositoryId", depositoryId);
        params.add("userId", userId);
        params.add("thumbsUp", thumbsUp);

        MvcResult mvcResult = mockMvc.perform(post(url+"/depositoryThumbsUp").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void addDepositoryMember() throws  Exception {
        String userId = "user2";
        String depositoryId = "7";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userId", userId);
        params.add("depositoryId", depositoryId);

        MvcResult mvcResult = mockMvc.perform(post(url+"/addDepositoryMember").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }

    @Test
    public void depositoryCollection() throws  Exception {
        String userId = "user1";
        String depositoryId = "7";
        String collection = "true";

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("userId", userId);
        params.add("depositoryId", depositoryId);
        params.add("collection", collection);

        MvcResult mvcResult = mockMvc.perform(post(url+"/collection").params(params)).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println(content);
    }
}