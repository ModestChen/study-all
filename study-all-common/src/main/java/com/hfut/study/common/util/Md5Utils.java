package com.hfut.study.common.util;

import java.security.MessageDigest;

/**
 * @auther zhanghui
 * @date 2017/8/18 14:23
 * @desc
 */
public class Md5Utils {
    public static String md5(String str) {
        MessageDigest md5 = null;
        try{
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        //zhanghui  输出  c593cc79d6afc605cec121e6f268fdfc
        System.out.println(md5("zhanghui"));
    }
}
