package com.mzd.mywy.myshiro.authority;

public enum AuthorityEnum {
    /**
     * 权限认证
     */
    role("角色", "role"),
    permit("权限点", "permit");
    private String permitDis;
    private String permitValue;

    AuthorityEnum(String permitDis, String permitValue) {
        this.permitDis = permitDis;
        this.permitValue = permitValue;
    }

    public static String getValue(AuthorityEnum permitEnum) {
        return permitEnum.permitValue;
    }
}
