package com.scu.hub.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDepositoryMapperTest {
    @Resource
    UserDepositoryMapper userDepositoryMapper;

    @Test
    public void getDepossitoryByUserId() {
        System.out.println(userDepositoryMapper.getDepossitoryByUserId("user1"));
    }

    @Test
    public void getUserDepoByUserId() {
        System.out.println(userDepositoryMapper.getUserDepoByUserId("user1"));
    }

    @Test
    public void getUserDepositoryByUserIdAndDeId() {
        System.out.println(userDepositoryMapper.getUserDepositoryByUserIdAndDeId("user1", 1));
    }

    @Test
    public void inserUserDepository() {
        System.out.println(userDepositoryMapper.inserUserDepository("user111", 20));
    }

    @Test
    public void updateRole() {
        System.out.println(userDepositoryMapper.updateRole(2, "user1", 6));
    }

    @Test
    public void updateThumbsUp() {
        System.out.println(userDepositoryMapper.updateThumbsUp(true, "user1", 3));
    }

    @Test
    public void updateCollection() {
        System.out.println(userDepositoryMapper.updateCollection(true, "user1", 3));
    }

    @Test
    public void getDepositoryThumsUpNumber() {
        System.out.println(userDepositoryMapper.getDepositoryThumsUpNumber(3));
    }

    @Test
    public void getDepositoryCollectionNumber() {
        System.out.println(userDepositoryMapper.getDepositoryCollectionNumber(3));
    }
}