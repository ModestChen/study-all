package com.hfut.study.common.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @Author:zhangzhennan
 * @Description: 验证工具类
 * @Date: Create in 10:51 2017/6/28
 */
public class ValidateUtils {

    /**
     * 是否为日期时间格式：yyyy-MM-dd hh:mm:ss or yyyy-MM-dd hh:mm
     * @param dateTime
     * @return
     */
    public static boolean isDateTime(String dateTime) {
        int first = dateTime.indexOf(":");
        int last = dateTime.lastIndexOf(":");
        if (first == -1) {
            return false;
        }
        SimpleDateFormat df = null;
        if (first == last) {
            df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        } else {
            df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        Date date = null;
        try {
            date = df.parse(dateTime);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 判断是否为有且只有小数点后面包含两位的数
     * @param str 传入的字符串
     * @return 是浮点数返回true,否则返回false
     */
    public static boolean isDoubleAnd2decimals(String str) {
        Pattern pattern = Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))([.](\\d){1,2})?$");
        return pattern.matcher(str).matches();
    }

    /**
     * @Description： 判断字符串是由纯数字组成，并且制定长度
     * @param src 待校验字符串
     * @param len 期望的长度
     * @Date: 11:21 2017/6/28
     */
    public static boolean isNumericWithFixLen(String src, int len){
        if (StringUtils.isBlank(src)) {
            return false;
        } else {
            if(src.matches("\\d*")){
                if(src.length()==len){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }

    /**
     * @Description： 判断字符串是由纯数字组成，并且判断最大长度
     * @param src 待校验字符串
     * @param len 期望的最大长度
     * @Date: 11:21 2017/6/28
     */
    public static boolean isNumericWithMaxLen(String src, int len){
        if (StringUtils.isBlank(src)) {
            return false;
        } else {
            if(src.matches("\\d*")){
                if(src.length()>len){
                    return false;
                }else{
                    return true;
                }
            }else{
                return false;
            }
        }
    }

    /*** 是否为url*/
    public static boolean isURL(String url) {
        Pattern pattern = Pattern
                .compile("^(https?|ftp):\\/\\/(((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|[A-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[A-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[A-Z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[A-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[A-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[A-Z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)+(\\/(([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(\\#((([a-z]|[A-Z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$");
        return pattern.matcher(url).matches();
    }

    public static void main(String[] args) {
        System.out.println(ValidateUtils.isDateTime("2017-12-12 12:12:12"));
    }

}
