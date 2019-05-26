package com.scu.hub.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DepositoryMapperTest {

    @Resource
    DepositoryMapper depositoryMapper;

    @Test
    public void getDepositoryById() {
        System.out.println(depositoryMapper.getDepositoryById(4));
    }

    @Test
    public void insertDepository() {
        System.out.println(depositoryMapper.insertDepository(400, "name", true, 3, "tagggggg"));
    }

    @Test
    public void getMaxId() {
        System.out.println(depositoryMapper.getMaxId());
    }

    @Test
    public void setVisibleById() {
        System.out.println(depositoryMapper.setVisibleById(1, 1));
    }

    @Test
    public void keywordMatching() {
        System.out.println(depositoryMapper.keywordMatching("de"));
    }
}