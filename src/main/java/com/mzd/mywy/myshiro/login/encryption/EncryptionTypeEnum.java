package com.mzd.mywy.myshiro.login.encryption;

/**
 * 加密类型
 *
 * @author Theodore
 * @since 2019/9/5 10:53
 */
public enum EncryptionTypeEnum {
    /**
     * 加密类型
     */
    Unencrypted("明文不加密", "Unencrypted"),
    Md5("Md5加密", "Md5");

    private String dis;
    private String type;

    EncryptionTypeEnum(String dis, String type) {
        this.dis = dis;
        this.type = type;
    }

    public static String getType(EncryptionTypeEnum encryptionTypeEnum) {
        return encryptionTypeEnum.type;
    }
}
