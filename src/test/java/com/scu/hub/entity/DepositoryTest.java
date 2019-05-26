package com.scu.hub.entity;

import org.junit.Before;
import org.junit.Test;

public class DepositoryTest {

    Depository depository;
    @Before
    public void before() {
        depository = new Depository(111, "fdsaga", "//", true, 11, "tag");
    }

    @Test
    public void getDepositoryId() {
        System.out.println(depository.getDepositoryId());
    }

    @Test
    public void setDepositoryId() {
        depository.setDepositoryId(1243);
    }

    @Test
    public void getDepositoryName() {
        System.out.println(depository.getDepositoryName());
    }

    @Test
    public void setDepositoryName() {
        depository.setDepositoryName("1243");
    }

    @Test
    public void getDepositoryPath() {
        System.out.println(depository.getDepositoryPath());
    }

    @Test
    public void setDepositoryPath() {
        depository.setDepositoryPath("1");
    }

    @Test
    public void getDepositoryVisiable() {
        System.out.println(depository.getDepositoryVisiable());
    }

    @Test
    public void setDepositoryVisiable() {
        depository.setDepositoryVisiable(false);
    }

    @Test
    public void getDepositoryClassificationId() {
        System.out.println(depository.getDepositoryClassificationId());
    }

    @Test
    public void setDepositoryClassificationId() {
        depository.setDepositoryClassificationId(1);
    }

    @Test
    public void getTags() {
        System.out.println(depository.getTags());
    }

    @Test
    public void setTags() {
        depository.setTags("4132");
    }
}