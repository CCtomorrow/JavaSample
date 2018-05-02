package com.qy.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Base64;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/3/7 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b> hmac sha1加密 <br>
 */
public class Hmac {

    /**
     * 获取http请求需要的Authorization header
     *
     * @param user        test
     * @param reqMethod   GET，POST
     * @param url         /api/list
     * @param httpVersion HTTP/1.1
     * @param secret      secret
     * @param date        Wed, 07 Mar 2018 13:58:48 GMT
     * @return hmac username="test",algorithm="hmac-sha1",headers="date request-line",signature="axQeFPPQOMncsMKfxY4BhaAETrs="
     */
    public static String getAuthHeaderStr(String user, String reqMethod, String url, String httpVersion, String secret, String date) {
        String algorithm = "hmac-sha1";
        String headsString = "date request-line";
        String authHeaderFormat = "hmac username=\"%1$s\",algorithm=\"%2$s\",headers=\"%3$s\",signature=\"%4$s\"";
        // date: date\n method url httpVersion
        // headers=date: Wed, 07 Mar 2018 10:34:51 GMT\nPOST /auth/sms/code HTTP/1.1
        String headsFormat = "date: %1$s\n%2$s %3$s %4$s";
        String headers = String.format(headsFormat, date, reqMethod, url, httpVersion);
        try {
            byte[] signature = hmacSHA1Encrypt(headers, secret);
            String signatureHash = Base64.getEncoder().encodeToString(signature);
            return String.format(authHeaderFormat, user, algorithm, headsString, signatureHash);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当前时间的gmt字符串
     *
     * @return Wed, 07 Mar 2018 13:58:48 GMT
     */
    public static String getDateGMTString() {
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(date);
    }

    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     *
     * @param encryptText 被签名的字符串
     * @param encryptKey  密钥
     * @return [B@7006c658
     * @throws Exception
     */
    public static byte[] hmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
        final String macStr = "HmacSHA1";
        final String encoding = "UTF-8";
        byte[] data = encryptKey.getBytes(encoding);
        SecretKey secretKey = new SecretKeySpec(data, macStr);
        Mac mac = Mac.getInstance(macStr);
        mac.init(secretKey);
        byte[] text = encryptText.getBytes(encoding);
        return mac.doFinal(text);
    }

}
