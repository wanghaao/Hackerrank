package com.scu.hub.entity;

public class Depository {
    private Integer depositoryId;
    private String depositoryName;
    private String depositoryPath;
    private Boolean depositoryVisiable;
    private Integer depositoryLike;
    private Integer depositoryCollection;
    private Integer depositoryClassificationId;
    private String tags;

    public Depository(Integer depositoryId, String depositoryName,
                      String depositoryPath, Boolean depositoryVisiable, Integer depositoryLike,
                      Integer depositoryCollection, Integer depositoryClassificationId,
                      String tags) {
        this.depositoryId = depositoryId;
        this.depositoryName = depositoryName;
        this.depositoryPath = depositoryPath;
        this.depositoryVisiable = depositoryVisiable;
        this.depositoryLike = depositoryLike;
        this.depositoryCollection = depositoryCollection;
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

    public Integer getDepositoryLike() {
        return depositoryLike;
    }

    public void setDepositoryLike(Integer depositoryLike) {
        this.depositoryLike = depositoryLike;
    }

    public Integer getDepositoryCollection() {
        return depositoryCollection;
    }

    public void setDepositoryCollection(Integer depositoryCollection) {
        this.depositoryCollection = depositoryCollection;
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
                ", depositoryLike=" + depositoryLike +
                ", depositoryCollection=" + depositoryCollection +
                ", depositoryClassificationId=" + depositoryClassificationId +
                ", tags='" + tags + '\'' +
                '}';
    }
}
