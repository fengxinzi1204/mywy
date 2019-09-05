package com.mzd.mywy.myshiro.login;

import com.mzd.mywy.myshiro.login.encryption.EncryptionTypeEnum;

public class MyMatcher {
    //加密类型（默认是不加密）
    private String Encryption_method = EncryptionTypeEnum.getType(EncryptionTypeEnum.Unencrypted);
    //加密次数
    private int times = 1;

    public String getEncryption_method() {
        return Encryption_method;
    }

    public void setEncryption_method(String encryption_method) {
        Encryption_method = encryption_method;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public MyMatcher(String encryption_method, int times) {
        Encryption_method = encryption_method;
        this.times = times;
    }

    public MyMatcher() {
    }
}
