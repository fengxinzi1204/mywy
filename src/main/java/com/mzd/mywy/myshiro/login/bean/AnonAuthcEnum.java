package com.mzd.mywy.myshiro.login.bean;

/**
 * 权限认证提示枚举
 *
 * @author Theodore
 * @since 2019/9/5 10:42
 */
public enum AnonAuthcEnum {
    /**
     * 权限认证提示枚举
     */
    anon("匿名登入", "anon"),
    authc("登入之后才能访问", "authc");
    private String sign;
    private String value;

    AnonAuthcEnum(String sign, String value) {
        this.sign = sign;
        this.value = value;
    }

    public static String getValue(AnonAuthcEnum anonAuthc) {
        return anonAuthc.value;
    }
}
