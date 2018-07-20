package com.qy.timezone;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/3/16 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b> 时区 <br>
 */
public class TimezoneSample {

    public static void main(String[] args) {
        timezone();

        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getRawOffset()/1000/60/60 + "");
        System.out.println(tz.getID());
    }

    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static void timezone() {
//        TimeZone timeZone = TimeZone.getDefault();
//        String name = timeZone.getDisplayName();
//        String id = timeZone.getID();
//        int offset = timeZone.getRawOffset() / (60 * 60 * 1000);
//        System.out.println(offset);

        long time = 1521350558L;
        SimpleDateFormat format = new SimpleDateFormat(FORMAT, Locale.getDefault());
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(8 * 60 * 60 * 1000);
        format.setTimeZone(timeZone);
        Date date = new Date(time * 1000);
        System.out.println(format.format(date));

        // 696351600000
        String s = "19920125230000";
        System.out.println(getLongTime(s, 8));
    }

    public static TimeZone getTimezoneWithOffset(int offset) {
        TimeZone timeZone = TimeZone.getDefault();
        timeZone.setRawOffset(offset * 60 * 60 * 1000);
        return timeZone;
    }

    public static long getLongTime(String t, int offset) {
        String pattern = "yyyyMMddHHmmss";
        SimpleDateFormat format = new SimpleDateFormat(pattern, Locale.getDefault());
        int base = 12;
        if (offset >= -base && offset <= base) {
            format.setTimeZone(getTimezoneWithOffset(offset));
        }
        try {
            return format.parse(t).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return System.currentTimeMillis();
    }

}
