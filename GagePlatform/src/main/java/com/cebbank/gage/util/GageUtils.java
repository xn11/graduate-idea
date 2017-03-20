package com.cebbank.gage.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xn on 2017/3/16.
 */
public class GageUtils {

    public static Date stringToDate(String dateStr, String format) throws ParseException {
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.parse(dateStr);
    }

    public static Date stringToDate(String dateStr) throws ParseException {
        return stringToDate(dateStr, "yyyy-MM-dd");
    }

    public static String dateToString(Date date, String format){
        DateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }

    public static String dateToString(Date date){
        return dateToString(date, "yyyy-MM-dd");
    }
}
