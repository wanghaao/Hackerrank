package com.scu.hub.entity;

public class Depository {
    private Integer depositoryId;
    private String depositoryName;
    private String depositoryPath;
    private Boolean depositoryVisiable;
    private Integer depositoryClassificationId;
    private String tags;

    public Depository(Integer depositoryId, String depositoryName, String depositoryPath, Boolean depositoryVisiable, Integer depositoryClassificationId, String tags) {
        this.depositoryId = depositoryId;
        this.depositoryName = depositoryName;
        this.depositoryPath = depositoryPath;
        this.depositoryVisiable = depositoryVisiable;
        this.depositoryClassificationId = depositoryClassificationId;
        this.tags = tags;
    }

    public Integer getDepositoryId() {
        return depositoryId;
    }

    public void setDepositoryId(Integer depositoryId) {
        this.depositoryId = depositoryId;
    }

    public String getDepositoryName() {
        return depositoryName;
    }

    public void setDepositoryName(String depositoryName) {
        this.depositoryName = depositoryName;
    }

    public String getDepositoryPath() {
        return depositoryPath;
    }

    public void setDepositoryPath(String depositoryPath) {
        this.depositoryPath = depositoryPath;
    }

    public Boolean getDepositoryVisiable() {
        return depositoryVisiable;
    }

    public void setDepositoryVisiable(Boolean depositoryVisiable) {
        this.depositoryVisiable = depositoryVisiable;
    }

    public Integer getDepositoryClassificationId() {
        return depositoryClassificationId;
    }

    public void setDepositoryClassificationId(Integer depositoryClassificationId) {
        this.depositoryClassificationId = depositoryClassificationId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "{" +
                "depositoryId=" + depositoryId +
                ", depositoryName='" + depositoryName + '\'' +
                ", depositoryPath='" + depositoryPath + '\'' +
                ", depositoryVisiable=" + depositoryVisiable +
                ", depositoryClassificationId=" + depositoryClassificationId +
                ", tags='" + tags + '\'' +
                '}';
    }
}
