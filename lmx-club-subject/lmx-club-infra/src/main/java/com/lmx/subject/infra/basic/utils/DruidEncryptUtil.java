package com.lmx.subject.infra.basic.utils;

import com.alibaba.druid.filter.config.ConfigTools;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 数据库加密
 * @author lmx
 * @package com.lmx.subject.infra.basic.utils
 * @date 2019/11/19 10:05
 * @description
 */

public class DruidEncryptUtil {
    private static String publicKey;

    private static String privateKey;

    static {
        try {
            String[] keyPair = ConfigTools.genKeyPair(512);
            publicKey = keyPair[0];
            System.out.println("publicKey:" + publicKey);
            privateKey = keyPair[1];
            System.out.println("privateKey:" + privateKey);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String password) {
        try {
            return ConfigTools.encrypt(publicKey, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String password) {
        try {
            return ConfigTools.decrypt(privateKey, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        String password = "02290922lmx";
        String encrypt = encrypt(password);
        System.out.println("加密后：" + encrypt);
        System.out.println("解密后：" + decrypt(encrypt));
    }
}
