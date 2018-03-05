package com.hfut.study.sso.client.util;

import com.hfut.study.sso.api.entity.UserInfo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * @author chenjia
 * @create 2018-02-06 14:42
 * @desc
 **/
public class SSOClient {
    public static final String COOKIESNAME = "ssocookie";
    public static final String COOKIESVALUE = "sso";
    public static final ArrayList<String> hiddenUrls = new ArrayList<String>();

    static {
        hiddenUrls.add("http://www.a.com:8080/demo1/addcookie");
        hiddenUrls.add("http://www.b.com:8080/demo2/addcookie");
    }

    //同域下的检查cookies
    public static boolean chickCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (COOKIESNAME.equals(cookie.getName())//
                        && COOKIESVALUE.equals(cookie.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    //    cookies校验通信
    public static String doGet(String url, UserInfo userInfo) {
        StringBuffer sb = new StringBuffer();
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        URL url1 = null;
        try {
            StringBuffer t_s = new StringBuffer(url).append("?");
            Field[] fields = UserInfo.class.getDeclaredFields();
            for (Field field : fields) {
                String attribute = field.getName();
                PropertyDescriptor pd = new PropertyDescriptor(attribute, UserInfo.class);
                t_s.append(attribute).append("=").append(pd.getReadMethod().invoke(userInfo)).append("&");
            }
            url = t_s.substring(0, t_s.length() - 1);
            url1 = new URL(url);
            httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            for (String temp = null; (temp = bufferedReader.readLine()) != null; temp = bufferedReader.readLine()) {
                sb.append(temp);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return sb.toString();
    }
}
