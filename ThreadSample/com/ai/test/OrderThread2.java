package com.ai.test;

import java.util.concurrent.*;

/**
 * <b>Project:</b> Sample <br>
 * <b>Create Date:</b> 2017/4/15 <br>
 * <b>Author:</b> qy <br>
 * <b>Address:</b> qingyongai@gmail.com <br>
 * <b>Description:</b> 如何让两个线程依次执行？B在A执行完成之后才执行 <br>
 */
public class OrderThread2 {

    private static Callable<Integer> callable = new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            System.out.println("Task starts");
            Thread.sleep(1000);
            int result = 0;
            for (int i = 0; i <= 100; i++) {
                result += i;
            }
            System.out.println("Task finished and return result");
            return result;
        }
    };

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable) {

            @Override
            protected void done() {
                if (isDone()) {
                    try {
                        Integer integer = get();
                        System.out.println("Result: " + integer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {

                }
            }
        };
        es.submit(futureTask);
        es.shutdown();
        System.out.println("主线程在工作");
//        try {
//            System.out.println("Before futureTask.get()");
//            System.out.println("Result: " + futureTask.get());
//            System.out.println("After futureTask.get()");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
    }

}
