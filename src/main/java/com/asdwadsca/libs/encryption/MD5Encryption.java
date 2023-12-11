package com.asdwadsca.libs.encryption;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encryption {
    /**
     * 该方法接受一个字符串值, 将其进行MD5加密后以String类型返回
     * 该方法返回String类型的值
     * 该方法抛出NoSuchAlgorithmException异常
     *
     * @param input_str     需要加密的字符串
     * @return              返回加密后的16位MD5值
     * @throws NoSuchAlgorithmException     当查询不到对应的加密手段时抛出
     */
    public static String MD5Enc_16bit(String input_str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(input_str.getBytes(StandardCharsets.US_ASCII));
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }
}
