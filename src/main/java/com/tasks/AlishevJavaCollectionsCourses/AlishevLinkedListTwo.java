package com.tasks.AlishevJavaCollectionsCourses;


import java.util.Arrays;

public class AlishevLinkedListTwo {
    // LinkedList - это реализация 2го списка
    // Метод remove() считается сильной отличительной стороной у LinkedList в отличии от ArrayList
    private Node head;
    private int size;

    public void add(int value) {
        // если это первое добавление в список
        if (head == null) {
            this.head = new Node(value);
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            // [1] -> [2] -> [3] -> [4]
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int get(int index) {
        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            if (currentIndex == index) {
                return temp.getValue();
            } else {
                temp = temp.getNext();
                currentIndex++;
            }
        }
        // [1] -> [2] -> [3] -> [4]
        throw new IllegalArgumentException();
    }

    // remove([2]) => [1] -> [2] -> [3]
    public void remove(int index) {
        if(index == 0) {
            // head переопределяем и указываем на следующий элемент в нашем списке
            head = head.getNext();
            return;
        }

        int currentIndex = 0;
        Node temp = head;

        while (temp != null) {
            // Нахождение предущего Узла -> перед Узлом который мы хотим удалить [2] -> [3]
            if (currentIndex == index - 1) {
                // Даем ссылку предыдущему Узлу на следующий узел после того узла который удаляем,
                // удаляя просто меням ссылки между узлами
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
            }
        }
    }

    @Override
    public String toString() {
        int[] result = new int[size];
        int index = 0;
        Node temp = head;

        while (temp != null) {
             result[index++] = temp.getValue();
             temp = temp.getNext();
        }
        return Arrays.toString(result);
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
