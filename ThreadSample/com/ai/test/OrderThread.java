package com.ai.test;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2017/4/15 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b> 如何让两个线程依次执行？B在A执行完成之后才执行 <br>
 */
public class OrderThread {

    public static void main(String[] args) {
        demo2();
    }

    private static void demo1() {
        Thread A = new Thread(() -> printNumber("A"));

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });

        A.start();
        B.start();
    }

    private static void demo2() {
        Thread A = new Thread(() -> printNumber("A"));

        Thread B = new Thread(() -> {
            System.out.println("B 等待 A 执行完成。");
            try {
                A.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNumber("B");
        });

        A.start();
        B.start();
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }

}
