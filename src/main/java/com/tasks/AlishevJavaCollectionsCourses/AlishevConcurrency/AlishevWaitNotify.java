package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import java.util.Scanner;

// Методы Object.wait() и Object.notify() - эти методы сделаны для работы с многопоточностью, эти методы
// автоматизируют паттерн работы Producer and Consumer
// Реализуем паттерн Producer and Consumer стандартными методами языка
public class AlishevWaitNotify {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify wn = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify {
    public void produce() throws InterruptedException {
        // synchronized (this) - синхронизуем текущий обьект тот куда наш this указывает, а это WaitAndNotify
        synchronized (this) {
            System.out.println("Producer thread started...");
            // wait() - вызывается на том обьекте, на котором определен наш синхронизованный блок
            //  wait() - нужно явно указывать на какой обьект ссылатся, по умолчанию this
            wait(); // 1 - отдаем intrinsic lock, как будто в этом потоке вышли из синхронизованного блока
            // 2 - ждем когда будет вызван notify()
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() throws InterruptedException{
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);
        synchronized (this) {
            // notify() - вызывается на том обьекте, на котором определен наш синхронизованный блок
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            // notifyAll() - на этом обьете synchronized (this), все потоки которые ждут, которые вызвали метод wait()
            // чтобы они проснулись
            // notify() - не возвращает монитор обьекта
            notify(); // notify() - пробуждает только 1 поток, notifyAll() - пробуждает все потоки которые ждут

            Thread.sleep(5000);
        }
    }
}
