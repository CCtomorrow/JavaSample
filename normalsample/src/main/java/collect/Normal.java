package collect;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2017/7/16 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b>  <br>
 */
public class Normal {

    public volatile int inc = 0;

    public Lock mLock = new ReentrantLock();

    public synchronized void increase() {
        inc++;
    }

    public synchronized void increase2() {
        mLock.lock();
        try {
            inc++;
        } finally {
            mLock.unlock();
        }
    }

    private class AtomicIntegerImpl {

        public AtomicInteger inc = new AtomicInteger();

        public void increase() {
            inc.getAndIncrement();
        }
    }

    public static void main(String[] args) {
//        final Normal test = new Normal();
//        for (int i = 0; i < 5; i++) {
//            new Thread() {
//                public void run() {
//                    for (int j = 0; j < 1000; j++)
//                        test.increase();
//                }
//            }.start();
//        }
//        while (Thread.activeCount() > 1)  //保证前面的线程都执行完
//            Thread.yield();
//        System.out.println(test.inc);
//
//
//        String s = null;
//
//        try {
//            System.out.println(s.charAt(0));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            FileInputStream stream = new FileInputStream("/Users/qingyong/Dev/Projects/mmcom/Sample/normalsample/src/main/java/country.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            // List<String> list = new ArrayList<String>();
            String line;
            while ((line = reader.readLine()) != null) {
                // list.add(line);
                String[] ss = line.split("[\t]");
                System.out.println("<item>" + ss[1] + "</item>");
//                System.out.println("<item>" + ss[1] + "\t+" + ss[4] + "</item>");
//                System.out.println("<item>" + ss[4] + "</item>");
            }
//            FileOutputStream stream2 = new FileOutputStream("/Users/qingyong/Dev/Projects/mmcom/Sample/normalsample/src/main/java/country2.txt");
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream2));
//            for (String s : list) {
//                writer.write(s, 0, s.length());
//                writer.newLine();
//                writer.flush();
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        Locale locale = Locale.TAIWAN;
//        System.out.println(locale.getLanguage());
//        System.out.println(locale.getCountry());
//
//        System.out.println(locale.getCountry().equalsIgnoreCase("tw"));
//        System.out.println("TW".equalsIgnoreCase(locale.getCountry()));

    }

}
