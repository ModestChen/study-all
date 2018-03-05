package com.hfut.study.sso.api.entity;

/**
 * @author chenjia
 * @create 2018-02-06 14:37
 * @desc 用户信息
 **/
public class UserInfo {
    private String userName;
    private String passWord;
    private String gotoUrl;
    private String cookiesName;
    private String cookiesValue;

    public String getCookiesName() {
        return cookiesName;
    }

    public void setCookiesName(String cookiesName) {
        this.cookiesName = cookiesName;
    }

    public String getCookiesValue() {
        return cookiesValue;
    }

    public void setCookiesValue(String cookiesValue) {
        this.cookiesValue = cookiesValue;
    }


    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
