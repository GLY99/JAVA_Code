package org.example.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputUtil {
    public static String formatLength(Long length) {
        if (length < 1024){
            return length + "B";
        }
        if (length < 1024 * 1024){
            return (length / 1024) + "KB";
        }
        if (length < 1024 * 1024 * 1024){
            return (length / (1024 * 1024)) + "MB";
        }
        return (length / (1024 * 1024 * 1024)) + "GB";

    }

    public static String formatTimeStamp(Long lastModifiedTimestamp) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置格式
        //df.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));//设置时区
        Date date = new Date(lastModifiedTimestamp);
        String dateStr = df.format(date);
        return dateStr;
    }
}
