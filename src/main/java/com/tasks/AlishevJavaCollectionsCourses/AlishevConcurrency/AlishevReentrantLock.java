package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ReentrantLock - помогает избежать deadlock, дублирует и автоматизирует ключевое слово synchronized и в некоторых
// случаях лучше использовать Lock чем synchronized
public class AlishevReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        task.firstThread();
                    }
                }
        );

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        task.secondThread();
                    }
                }
        );

        thread1.start();
        thread2.start();

        thread1.join();
        thread1.join();

        task.showCounter();
    }
}

class Task {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }

    public void firstThread() {
        lock.lock();  // работает как synchronized
        increment();
        lock.unlock();  // работает как synchronized
    }

    public void secondThread() {
        lock.lock(); // работает как synchronized
        increment();
        lock.unlock();  // работает как synchronized
    }

    public void showCounter() {
        System.out.println(counter);
    }
}
