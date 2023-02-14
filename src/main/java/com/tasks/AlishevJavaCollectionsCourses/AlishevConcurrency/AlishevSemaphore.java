package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import java.util.concurrent.Semaphore;

public class AlishevSemaphore {
// Semaphore класс используется в том случае когда у нас есть какой то ресурс и много потоков используют этот
// ресурс, Semaphore класс нужен когда мы хотим ограничить доступ к этому ресурсу, например у нас есть соединение
// с сервером и 10 потоков пишут в этот сервер, в этом случае сервер и соединение это ресурс, и пропускная способность
// кабеля она ограничена, и мы хотим эту пропускную способность, этот ресурс делить между потоками с помощью Semaphore

    public static void main(String[] args) {
        // Ложим количество разрешений для потоков, ограничить количество потоков, обращений
        Semaphore semaphore = new Semaphore(3);

        try { // В том случае когда мы в потоке начинаем взаимодействовать с ресурсом
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();

            System.out.println("All permits have been acquired");
            semaphore.acquire();
            System.out.println("Can't reach here...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // release() - отдает разрешение, вызываем release() когда в потоке заканчиваем использовать ресурс
        semaphore.release();
        // availablePermits() - возвращает количество разрешений
        System.out.println(semaphore.availablePermits());
    }
}
