package com.demo.bean;

public class Code {

    /**
     * 成功
     */
    public static final int SUCCESS = 1;

    /**
     * 失败 
     */
    public static final int FAIL = 0;

    /**
     * 参数错误: 一般是缺少或参数值不符合要求
     */
    public static final int ARGUMENT_ERROR = 2;

    /**
     * 服务器错误
     */
    public static final int ERROR = 500;

    /**
     * 接口不存在
     */
    public static final int NOT_FOUND = 404;

    /**
     * 帐号已存在*
     */
    public static final int ACCOUNT_EXISTS = 3;

}
