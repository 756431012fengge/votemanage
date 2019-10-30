package com.freesun.votemanager.commons;

public interface Constast {
    //状态码
    Integer SUCCESS=200;
    Integer FAILE=100;

    //消息message
    String LOGIN_SUCCESS="登录成功!";
    String LOGIN_FAILE="用户名或密码不正确!";
    String USERNAME_CAN_USE = "用户名可以使用";
    String USERNAME_IS_EXIST = "用户名已存在";
    String REG_SUCCESS ="注册成功!" ;
    String REG_FAILE = "注册失败!";
    String LOGIN_AGAIN="用户重复登录";

    //用户角色
    Integer  NORMAL_USER=2;
    Integer  SUPER_USER=1;

    //用户在线
    Integer IS_ONLINE=0;
    Integer NOT_ONLINE =1;

};
