package com.tasks.SourceCodeChannel.Collections;

import java.sql.Array;
import java.util.*;

public class CollectionQueue {

    // Queue - нужна для хранения элементов в однонаправленной очереди, элементы добавляются в очередь по принципу
    // FIFO - First In First Out - 1й добавленный элемент в очередь, будет 1м удаленным из нее

    // PriorityQueue - есть одно единственное прямой реализации queue, элементы очереди могут быть отсортированы с помощью
    // comparator, так PriorityQueue не может содержать элементы со значением null

    // Comparator - элементы очереди могут отсортированы с помощью Comparator

    public static void main(String[] args) {
        Comparator<Integer> comparator = (var1, var2) -> {
          if (var1 > var2) return -1;
          if (var1 < var2) return 1;
          return 0;
        };

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Integer[] array = new Integer[] {1, 5, 8, 0, 1};
        // Добавляем через addAll добавляем в очередь элементы из массива с числами
        Collections.addAll(priorityQueue, array);
        // Выедем в консоль заполненнную очередь
        System.out.println("Original PriorityQueue: " + priorityQueue);
        // Преобразуем очередь в массив, сортируем его используя Comparator
        priorityQueue.toArray(array);
        Arrays.sort(array, comparator);
        System.out.println("Sorted PriorityQueue: " + Arrays.toString(array));

    }

   /* public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Integer[] array = new Integer[]{4, 3, 1, 5, 2, 0};

        for (int i = 0; i < array.length; i++) {
            // Вставляет указанный элемент в эту очередь приоритетов.
            priorityQueue.offer(array[i]);
        }
        // Выводим элементы в неправильном порядке
        System.out.println("PriorityQueue elements: " + priorityQueue);
    }
*/

    /*public static void main(String[] args) {

        // Создаем Queue который будет использовать LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        int[] array = new int[] {1, 2, 0, 4, 3};

        // Закидываем все из array в elements
        for (int elements : array) {
            queue.add(elements);
        }
        System.out.println("Original queue: " + queue);
        // queue.isEmpty() - Пуста ли очередь?
        System.out.println("Is queue empty? " + queue.isEmpty());
        //  queue.remove()); - Удалить 1й элемент
        System.out.println("Delete element: " + queue.remove());
        System.out.println("Queue after removing element: " + queue);

        while (!queue.isEmpty()) {
            queue.remove();
        }
        // queue.peek()); - Выводим на экран начальный элемент очереди
        System.out.println("Head of queue: " + queue.peek());

    }*/

}
