package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Паттерн производитель и потребитель - чаще всего встречается в Многопоточном программировании
// Паттерн производитель и потребитель, в многопоточном программировании это означает что 1 или болле потоков
// производят что то, а 1 или более потоков потребляют что то, из жизни производитель это человек который создает
// мат задачи и дает компьютеру, несколько людей например нескольким компьютерам
public class AlishevPatternProducerConsumer {
    // java.util.concurrent - все классы потокобезопасны, все они synchronized, == threadsafe
    // Потокобезопасная очередь, фиксированный размер, это очередь создана чтобы работать с множеством потоков
    private static  BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {

        // Этот поток производит рандомные числа из очереди
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Этот поток запускает, производит рандомные числа из очереди
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // производит рандомные числа из очереди
    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
            queue.put(random.nextInt(100));
        }
    }

    // потребитель потребляет, берет числа из очереди
    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);

            if(random.nextInt(10) == 5) {
                System.out.println(queue.take());
                System.out.println("Queue size is " + queue.size());
            }
        }
    }
}
