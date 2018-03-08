package com.ai.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final int MODE_SHIFT = 30;
    private static final int MODE_MASK = 0x3 << MODE_SHIFT;

    private static final String str = "你是不是傻？；";

    public enum YIJI {
        /**
         * 日值岁破
         */
        SUIPO,
        /**
         * 大事不宜
         */
        BUYI,
        /**
         * 日值上朔
         */
        SHANGSHUO,
        /**
         * 大事勿用
         */
        WUYONG
    }

    private static String[] splitData(String data) {
        if (data == null || data.length() <= 0) {
            return new String[2];
        }
        if (data.charAt(0) != '#') {
            data = "#" + data;
        }
        String[] result = new String[2];
        String reg = "#(.*?)-";
        String reg2 = "-(.*?)#";
        String[] split = data.split(reg);
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s != null && s.length() > 0) {
                sb.append(s).append("#");
            }
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        //简版
        result[0] = sb.toString();
        sb.delete(0, sb.length());
        String[] split2 = data.split(reg2);
        for (String s : split2) {
            if (s != null && s.length() > 0) {
                sb.append(s).append("#");
            }
        }
        if ('#' == sb.charAt(0)) sb.deleteCharAt(0);
        if ('#' == sb.charAt(sb.length() - 1)) sb.deleteCharAt(sb.length() - 1);
        if (sb.lastIndexOf("-") >= 0) {
            sb.delete(sb.lastIndexOf("-"), sb.length());
        }
        result[1] = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        long s = 0x3 << 30;
        System.out.println(MODE_MASK);
        String[] strings = str.split("[;；]");

        Object o = YIJI.SUIPO;
        System.out.println(o.toString());

        String yiji = "#AA-aa#BB-bb#CC-";

        String[] res = splitData(yiji);

        System.out.println(res[0]);
        System.out.println(res[1]);

        long time = 761252400000L;
        SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd HH");

        Date date = new Date(time);

        System.out.println(format.format(date));

        System.out.println(Main.class.getCanonicalName());

        String ss = "gg";
        System.out.println(ss.split("[#]")[0]);

    }
}
