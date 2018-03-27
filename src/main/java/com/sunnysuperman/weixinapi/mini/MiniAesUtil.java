package com.sunnysuperman.weixinapi.mini;

import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class MiniAesUtil {
    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    private static byte[] padKey(byte[] key) {
        int base = 16;
        if (key.length % base != 0) {
            int groups = key.length / base + (key.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(key, 0, temp, 0, key.length);
            key = temp;
        }
        return key;
    }

    public static byte[] decrypt(byte[] content, byte[] key, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding", "BC");

        key = padKey(key);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");

        AlgorithmParameters params = AlgorithmParameters.getInstance("AES");
        params.init(new IvParameterSpec(iv));

        cipher.init(Cipher.DECRYPT_MODE, keySpec, params);

        byte[] original = cipher.doFinal(content);
        return original;
    }
}
