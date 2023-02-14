package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

public class AlishevConcurrencyOne {
    // Многопоточность одновременное выполнение различных участков кода в программе
    // на процессорах с несколькими ядрами будет выполнятся несколько потоков быстрее
    // основная цель многопоточного программирования реализовать какой либо функционал, чтобы клиент не ждал выполнения
    // задачи, а мог продожать свои действия с программой, а задачи обрабатывались бы на фоновом режиме
    // или наприме веб сервер, когда пользователь обращается к серверу, то сервер создает для него отдельный поток

    // Не гарантируется то что если мы вызовем поток в main методе то он выполнится 1м, ПОТОКИ не синхронизированы
    // они могут выполнятся в любом порядке, ПОТОКИ будут постоянно боротся за процессорное время, поэтому при каждом
    // запуске программы мы будем видеть разную выдачу потоков
    public static void main(String[] args) throws InterruptedException {
        /*MyThread myThread0 = new MyThread();
        // start() - запускает поток
        myThread0.start();

        Thread.sleep(1000);

        MyThread myThread1 = new MyThread();
        myThread1.start();
        System.out.println("Hello from main thread");

        // когда поток доходит до метода sleep() этот поток засыпает на указанное время
        System.out.println("Iam going to sleep...");
        Thread.sleep(3000);
        System.out.println("I am awake!!!");*/

        // другой способ создания потока, Даже если поток main завершил свою работу, будут выполнятся другие потоки
        // которые будут выполнятся в методе main
        // Потоки не синхронизированы и выполняются хаотично, по разному, пока мы не будем контролировать их
        Thread thread = new Thread(new Runner());
        thread.start();
        System.out.println("Hello from main thread");
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            try {
                // Через Thread мы можешь контролировать время выполнения потока, контролировать когда какой будет
                // запускатся
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}

// Synchronized (с англ. "синхронизированный") - это ключевое слово,
// которое позволяет заблокировать доступ к методу или части кода, если его уже использует другой поток.
// start() - synchronized потоки никак не синхронизируются между собой, выполняются всегда поочереди
// будет парарельно запускатся 2 потока, поток main и поток thread
class MyThread extends Thread {
    // Переопределяем метод run(), в нем будет содержатся логика потока, при запуске потока
    public void run() {
        for(int i = 0; i < 1000; i++) {
            try {
                // Через Thread мы можешь контролировать время выполнения потока, контролировать когда какой будет
                // запускатся
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from MyThread " + i);
        }
    }
}