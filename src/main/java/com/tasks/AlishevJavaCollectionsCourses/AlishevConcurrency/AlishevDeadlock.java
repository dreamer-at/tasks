package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlishevDeadlock {
    public static void main(String[] args) throws InterruptedException {
        AlishevRunner alishevRunner = new AlishevRunner();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                alishevRunner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                alishevRunner.secondThread();
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        alishevRunner.finished();
    }
}

class AlishevRunner {
    private AlishevAccount account1 = new AlishevAccount();
    private AlishevAccount account2 = new AlishevAccount();
    // Предположим что в жизни будет не 2 счета, а 10 счетов, и мы хотим выполнять lock() на разных порядках, в первом
    // потоке и во 2м потоке, в разном порядке, то может быть вызван deadlock(), этот тот случай когда мы резервируем
    // и освобождаем потоки в разном порядке
    // deadlock - это когда 2 потока ждут когда каждый из них отдасть свой поток, они не отдают свои lock()-и,
    // они ждут друг друга,  1й поток никогда не отдасть свой 1й lock(), а 2й поток не отдаст свой 2й lock()
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    // С ключевым словом synchronized все будет тоже самое что и с ReentrantLock(), но исправить только deadlock
    // используя lock() строго по порядку

    // ReentrantLock - позволяет забирать потоки в разных порядках не беспокоясь о deadlock, реализуем через takeLocks
    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                // tryLock() - проверяем занят ли поток?, если занят возвращаем false
                firstLockTaken = lock1.tryLock();
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken && secondLockTaken) {
                    return;
                }

                if (firstLockTaken) {
                    lock1.unlock();
                }

                if (secondLockTaken) {
                    lock2.unlock();
                }
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
           /* lock1.lock();
            // 1й поток здесь, он освободился но он не может взять 2й поток потому что 2й поток тоже отработался, поэтому
            // нужно запускать последовательно потоки
            lock2.lock();*/

            takeLocks(lock1, lock2);

            try {
                AlishevAccount.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            /*lock2.lock();
            // 2й поток здесь
            lock1.lock();*/
            takeLocks(lock2, lock1);
            try {
                    AlishevAccount.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance " + (account1.getBalance() + account2.getBalance()));
    }
}

class AlishevAccount {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }

    // Операция перевода между счетами
    public static void transfer (AlishevAccount acc1, AlishevAccount acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}
