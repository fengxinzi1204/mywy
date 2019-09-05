package com.mzd.mywy.myshiro.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Theodore
 * @since 2019/9/5 11:00
 */
public class DoMatch {

    private char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * md5加密
     *
     * @param password
     * @param salt
     * @param time
     * @return
     */
    public String Md5(String password, String salt, int time) {
        String returnpasswrod = password + salt;
        for (int i = 0; i < time; i++) {
            returnpasswrod = getMd5(returnpasswrod);
        }
        return returnpasswrod;
    }

    public String getMd5(String s) {
        try {
            byte[] strTemp = s.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
