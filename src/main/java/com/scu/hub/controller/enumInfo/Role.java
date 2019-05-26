package com.scu.hub.controller.enumInfo;

public class Role {
    public static final Integer OWNER = 0;//拥有，所以增删改查
    public static final Integer MANAGER = 1;//增删查
    public static final Integer PARTNER = 2;//增查
    public static final Integer DEFAULT = 999;//查

    private Role(){}
}
