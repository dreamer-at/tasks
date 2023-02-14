package com.tasks.AlishevJavaCollectionsCourses;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class AlishevQueue {
    // LIFO, Last in First out, последний вошел, вышел 1м, как очередь в магазине
    // интерфейс Collection API -> Queue -> LinkedList реализация
    public static void main(String[] args) {
        QueuePerson person1 = new QueuePerson(1);
        QueuePerson person2 = new QueuePerson(2);
        QueuePerson person3 = new QueuePerson(3);
        QueuePerson person4 = new QueuePerson(4);

        Queue<QueuePerson> people1 = new LinkedList<>();
        people1.add(person3);
        people1.add(person2);
        people1.add(person4);
        people1.add(person1);

        // person3 <- person2 <- person4 <- person1
        // при выводе на экран будет очередь FIFO, кто 1м зашел тот 1м и вышел, например мы добавили people.add(person3);
        // то этот элемент и выйдет 1м из очереди, то есть мы видим как соблюдается очередь
        for(QueuePerson person : people1) {
            System.out.println(person);
        }

        System.out.println();

        // в ArrayBlockingQueue мы должны указывать количество элементов изначально, используется для ограничения количества обьектов
        Queue<QueuePerson> people2 = new ArrayBlockingQueue<QueuePerson>(10);
        people2.add(person3);
        people2.add(person2);
        people2.add(person4);
        people2.add(person1);
        // person3 <- person2 <- person4 <- person1
        // remove() метод удаляет Node, элемент с головы
        System.out.println(people2.remove());
        // peek() - достать элемент из очереди
        System.out.println(people2.peek());
        System.out.println(people2);

        System.out.println();

        //             Бросает исключение   Возвращает специальное значение
        //             Throws exception	    Returns special value
        // Insert	   add(e)	            offer(e)
        // Remove	   remove()	            poll()
        // Examine	   element()	        peek()
        Queue<QueuePerson> people3 = new ArrayBlockingQueue<>(3);
        /*
        people3.add(person3);
        people3.add(person2);
        people3.add(person4);
        people3.add(person1);
        */
        //
        System.out.println(people3.offer(person3));
        System.out.println(people3.offer(person2));
        System.out.println(people3.offer(person4));
        System.out.println(people3.offer(person1)); // тут он вернет false
    }
}

class QueuePerson {
    private int id;

    public QueuePerson(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QueuePerson{" +
                "id=" + id +
                '}';
    }
}