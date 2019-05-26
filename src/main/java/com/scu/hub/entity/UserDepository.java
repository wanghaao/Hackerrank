package com.scu.hub.entity;

public class UserDepository {
    private String userId;
    private Integer depositoryId;
    private Integer privilege;

    public UserDepository(String userId, Integer depositoryId, Integer privilege) {
        this.userId = userId;
        this.depositoryId = depositoryId;
        this.privilege = privilege;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDepositoryId() {
        return depositoryId;
    }

    public void setDepositoryId(Integer depositoryId) {
        this.depositoryId = depositoryId;
    }

    public Integer getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Integer privilege) {
        this.privilege = privilege;
    }

}
