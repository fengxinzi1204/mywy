package com.mzd.mywy.myshiro.authority;

/**
 * 缓存枚举
 *
 * @author Theodore
 * @since 2019/9/5 10:48
 */
public enum CacheEnum {
    /**
     * 缓存枚举
     */
    ifatuthc("ifatuthc", "是否授权"),
    iflogin("iflogin", "是否登入");

    private String value;
    private String dis;

    CacheEnum(String value, String dis) {
        this.value = value;
        this.dis = dis;
    }

    public static String getValue(CacheEnum cacheEnum) {
        return cacheEnum.value;
    }
}
