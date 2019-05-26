package com.scu.hub.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDepositoryTest {

    UserDepository userDepository;
    @Before
    public void before() {
        userDepository = new UserDepository("user1", 1, 0, true, true);
    }

    @Test
    public void getUserId() {
        System.out.println(userDepository.getUserId());
    }

    @Test
    public void setUserId() {
        userDepository.setUserId("413");
    }

    @Test
    public void getDepositoryId() {
        System.out.println(userDepository.getDepositoryId());
    }

    @Test
    public void setDepositoryId() {
        userDepository.setDepositoryId(142);
    }

    @Test
    public void getRoleId() {
        System.out.println(userDepository.getRoleId());
    }

    @Test
    public void setRoleId() {
        userDepository.setRoleId(1);
    }

    @Test
    public void getThumbsUp() {
        System.out.println(userDepository.getThumbsUp());
    }

    @Test
    public void setThumbsUp() {
        userDepository.setThumbsUp(true);
    }

    @Test
    public void getCollection() {
        System.out.println(userDepository.getCollection());
    }

    @Test
    public void setCollection() {
        userDepository.setCollection(true);
    }
}