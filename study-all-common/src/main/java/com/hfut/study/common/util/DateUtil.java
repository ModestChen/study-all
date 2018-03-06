package com.hfut.study.common.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Write class comments here
 * *
 * User: jl
 * Date: 2017/7/6 0006 下午 2:41
 * version $Id: DateUtil.java, v 0.1 Exp $
 */
public final class DateUtil {
//    private static final Log log = LogFactory.getLog(com.sunyard.frameworkset.util.DateUtil.class);
    private static FastDateFormat fastDateFormat;
    //获取系统机器日期
    public static String getSysDate()
    {
        String curDate = "";
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR); //年
        int month = ca.get(Calendar.MONTH)+1; //月
        int day  = ca.get(Calendar.DAY_OF_MONTH); //日
        curDate = String.valueOf(year)+String.format("%02d",month)+String.format("%02d",day);
        return curDate;
    }

    //获取系统机器时间hhmmss
    public static String getSysTime()
    {
        String curTime = "";

        Calendar ca = Calendar.getInstance();
        int hour=ca.get(Calendar.HOUR);//小时
        int minute=ca.get(Calendar.MINUTE);//分
        int second=ca.get(Calendar.SECOND);//秒
        curTime = String.valueOf(hour)+String.valueOf(minute)+String.valueOf(second);
        return curTime;
    }
    public static String getSysDateTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd HH:mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    public static String _getSysDate()
    {
        String curDate = "";
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR); //年
        int month = ca.get(Calendar.MONTH)+1; //月
        int day  = ca.get(Calendar.DAY_OF_MONTH); //日
        curDate = String.valueOf(year)+"-"+String.format("%02d",month)+"-"+String.format("%02d",day);
        return curDate;
    }
    public static String getDateTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String strDate = sdf.format(new Date());
        return strDate.toString();
    }

    public static String getDateTime() {
        return getDateTime("yyyyMMddHHmmss");
    }

    public static String getDate() {
        return getDateTime("yyyyMMdd");
    }

    public static String getTime() {
        return getDateTime("HHmmss");
    }

    public static boolean isValidDate(String strDate, String format) {
        boolean islegal = false;

        try {
            String e = date2Str(str2Date(strDate, format), format);
            if(e.equals(strDate)) {
                islegal = true;
            }

            return islegal;
        } catch (Exception var4) {
//            log.error("", var4);
            return false;
        }
    }

    public static String date2Str(Date date) {
        String format = "yyyy-MM-dd HH:mm:ss";
        return date2Str(date, format);
    }

    public static String date3Str(Date date) {
        String format = "yyyy-MM-dd";
        return date2Str(date, format);
    }

    public static String date2Str(Date date, String format) {
        fastDateFormat = FastDateFormat.getInstance(format);
        return fastDateFormat.format(date);
    }

    public static String formatDateTime(String dateStr, String newFormat) {
        return formatDateTime(dateStr, newFormat, "yyyyMMddHHmmss");
    }

    public static String formatDateTime(String dateStr, String newFormat, String oldFormat) {
        if(isValidDate(dateStr,oldFormat)){
            Date date = str2Date(dateStr, oldFormat);
            return date2Str(date, newFormat);
        }else{
            return "";
        }

    }

    public static Date str2Date(String sDate, String format) {
        try {
            return (new SimpleDateFormat(format)).parse(sDate);
        } catch (ParseException var3) {
//            log.error("", var3);
            return null;
        }
    }

    public static Date addDate(Date date, int counts, int dateField) {
        GregorianCalendar curGc = new GregorianCalendar();
        if(date != null) {
            curGc.setTime(date);
        }

        curGc.add(dateField, counts);
        return curGc.getTime();
    }

    public static Date addDate(Date date, int days) {
        return addDate(date, days, 5);
    }

    public static String addDate(String date, int days, String format) {
        return date2Str(addDate(str2Date(date, format), days, 5), format);
    }

    public static Date addMonth(Date date, int months) {
        return addDate(date, months, 2);
    }

    public static String addMonth(String date, int months, String format) {
        return date2Str(addDate(str2Date(date, format), months, 2), format);
    }

    public static String lastDateOfMonth(String date) {
        return date2Str(addDate(addDate(str2Date(date.substring(0, 6) + "01", "yyyyMMdd"), 1, 2), -1, 5), "yyyyMMdd");
    }

    public static String getWeekDay(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("E");
        return formatter.format(str2Date(date, "yyyyMMdd"));
    }

    public static long getTwoDateMinus(Date date1, Date date2) {
        long sec1 = date1.getTime();
        long sec2 = date2.getTime();
        long minus = sec2 - sec1;
        if(minus < 0L) {
            minus = 0L - minus;
        }

        long day = 86400000L;
        return minus / day;
    }

    public static boolean validate(String s) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            formatter.parse(s);
            boolean var3 = false;
            return true;
        } catch (ParseException var4) {
            return false;
        }
    }

    public static String getXunDate(Date date) {
        String dateStr = date2Str(date, "yyyyMMdd");
        int day = Integer.valueOf(dateStr.substring(6, 8)).intValue();
        return day <= 10?dateStr.substring(0, 6) + "1":(day <= 20?dateStr.substring(0, 6) + "2":dateStr.substring(0, 6) + "3");
    }

    public static String yyMMddToyy_MM_dd(String date) {
        if(date!=null&& !StringUtils.isEmpty(date)){
            String yyyy=date.substring(0,4);
            String MM=date.substring(4,6);
            String dd=date.substring(6,8);
            if(date.length()>8){
                String hhss=date.substring(8,date.length());
                return yyyy+"-"+MM+"-"+dd+" "+hhss;
            }
            return yyyy+"-"+MM+"-"+dd;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(validate("2017-08-31 10:12:12"));
        System.out.println(date2Str(str2Date("2017-01-01 12:12:12", "yyyy-MM-dd HH:mm:ss"),"yyyy-MM-dd"));
    }
}
