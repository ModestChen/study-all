package com.hfut.study.sso.server.util;


import com.hfut.study.sso.api.entity.UserInfo;

/**
 * @author chenjia
 * @create 2018-02-06 14:42
 * @desc
 **/
public class SSOServer {
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "123456";
    public static final String COOKIESNAME = "ssocookie";
    public static final String COOKIESVALUE = "sso";

    public static boolean checkLogin(UserInfo userInfo) {
        if (userInfo != null) {
            if (USERNAME.equals(userInfo.getUserName()) && PASSWORD.equals(userInfo.getPassWord())) {
                return true;
            }
        }
        return false;
    }

    public static boolean chickCookie(String cookiesName, String cookiesValue) {
        if (COOKIESNAME.equals(cookiesName)//
                && COOKIESVALUE.equals(cookiesValue)) {
            return true;
        }
        return false;
    }
}
