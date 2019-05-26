package com.scu.hub.entity;

public class UserDepository {
    private String userId;
    private Integer depositoryId;
    private Integer roleId;
    private Boolean thumbsUp;
    private Boolean  collection;

    public UserDepository(String userId, Integer depositoryId, Integer roleId, Boolean thumbsUp, Boolean collection) {
        this.userId = userId;
        this.depositoryId = depositoryId;
        this.roleId = roleId;
        this.thumbsUp = thumbsUp;
        this.collection = collection;
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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Boolean getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(Boolean thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public Boolean getCollection() {
        return collection;
    }

    public void setCollection(Boolean collection) {
        this.collection = collection;
    }
}
