package com.tasks.AlishevJavaCollectionsCourses.AlishevConcurrency;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.concurrent.*;

public class AlishevCallableFuture {
    int result;
// При помощи Callable() и Future() == мы получаем значение как от обычных обьектов
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // new Callable<Integer> - возвращает тот тип который указан в дженериках
        // Если мы будем делать через лямбду выражение () ->, Java сама будет понимать Runnable() это или Callable()
        // в зависимости от того будет указан return или не будет указан

        // Как получить доступ через возвращаемое значение, через интерфейс Future, параметризуем так же как и Callable()
        Future<Integer> future = executorService.submit(() -> {
                System.out.println("Starting...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");

                Random random = new Random();
                int randomValue = random.nextInt();

                if(randomValue < 5) // Создаем ситуацию в потоке для исключения
                    throw new Exception("Something bad happened");

                return random.nextInt(10);
        });
        executorService.shutdown();

        try { // Так же при помощи Callable() и Future() == мы можем Возвращать значения из потоков,
            // а так же выбрасывать исключение из потоков
            int result = future.get(); // дожидается окончания выполнения потока
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) { // Предком ловим исключения
            Throwable ex = e.getCause();
            System.out.println(ex.getMessage());
        }
    }
}

