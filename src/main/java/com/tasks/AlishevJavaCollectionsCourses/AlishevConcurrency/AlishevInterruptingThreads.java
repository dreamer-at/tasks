package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import java.util.Random;

public class AlishevInterruptingThreads { // InterruptedException - вызывается тогда когда поток был прерван
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 1_000_000_000; i++) { // isInterrupted() - завершаем поток
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread is interrupted");
                        break;
                    }
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Starting Thread!");

        thread.start();
        Thread.sleep(1);
        // interrupt() - вызывается на потоке, который был прерван
        thread.interrupt();
        thread.join();

        System.out.println("Thread is finished!");

    }
}
