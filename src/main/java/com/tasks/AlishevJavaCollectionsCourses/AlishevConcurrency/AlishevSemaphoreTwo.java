package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class AlishevSemaphoreTwo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(200);

        // Создали 200 потоков на подключение, ограничим их подключение до 10 с помощью Semaphore
        Connection connection = Connection.getConnection();
        for (int i =0; i < 200; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}

// Такая конструкция класса гарантирует создание только 1го экзэмляра класса Connection как подключение,
// и только он будет использоватся == Singleton
class Connection {
    private static Connection connection = new Connection();
    private int connectionsCount;
    // Создали 200 потоков на подключение, ограничим их подключение до 10 с помощью Semaphore
    Semaphore semaphore = new Semaphore(10);

    private Connection() {

    }

    public static Connection  getConnection() {
        return connection;
    }

    public void work() throws InterruptedException {
        semaphore.acquire();// В том случае когда мы в потоке начинаем взаимодействовать с ресурсом
        try {
            doWork();
        } finally {
            // release() - отдает разрешение, вызываем release() когда в потоке заканчиваем использовать ресурс
            semaphore.release();
        }
    }

    public void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println(connectionsCount);
        }
        Thread.sleep(5000);

        synchronized (this) {
            connectionsCount--;
        }
    }
}
