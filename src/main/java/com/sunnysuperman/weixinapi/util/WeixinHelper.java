package com.sunnysuperman.weixinapi.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sunnysuperman.commons.util.StringUtil;

// TODO XXX move to DigestUtils
public class WeixinHelper {
    private static final String ALPHA_NUMERIC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String randomAlphanumeric(int length) {
        return StringUtil.randomString(ALPHA_NUMERIC, length);
    }

    public static String digest(String s, String algorithm) {
        byte[] unencodedPassword = s.getBytes();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        md.reset();
        // call the update method one or more times
        // (useful when you don't know the size of your data, eg. stream)
        md.update(unencodedPassword);
        // now calculate the hash
        byte[] bytes = md.digest();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                result.append("0");
            }
            result.append(Long.toString((int) bytes[i] & 0xff, 16));
        }
        return result.toString();
    }

    public static String md5(String s) {
        return digest(s, "MD5");
    }

}
