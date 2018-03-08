package com.qy.lunar;

import org.junit.Test;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2018/1/24 <br>
 * <b>@author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b> 测试 <br>
 */
public class LunarTest {

    @Test
    public void lunarTest() {
        trans(2017, 6, 25);
        trans(2017, 7, 23);
        // 数据只到了2111年
        trans(2111, 12, 31);
    }

    private void trans(int year, int yue, int day) {
        String origin = String.format("%1$s年%2$s月%3$s日", year, yue, day);
        System.out.print("公历" + origin + "===>");
        int[] res = LunarUtil.solarToLunar(year, yue, day);
        String news = String.format("%1$s年%2$s月%3$s日 闰月:%4$s", res[0], res[1], res[2], res[3]);
        System.out.print("农历" + news + "\n");
    }

    @Test
    public void solarTest() {
        String[] res = SolarTermUtil.getSolarTerms(3058);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
