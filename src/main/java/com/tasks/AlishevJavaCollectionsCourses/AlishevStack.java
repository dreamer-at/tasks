package com.tasks.AlishevJavaCollectionsCourses;
import java.util.Stack;

public class AlishevStack {
    public static void main(String[] args) {
        // LIFO, Last In First Out, последний зашел, 1й вышел
        Stack<Integer> stack = new Stack<>();
        // 5 <- 3 <- 1, в случае Queue FIFO - мы бы получили 1й элемент 5, потому что он был добавлен 1м
        // 5 <- 3 <- 1, НО в случае со Stack у нас наоборот, кто последним вошел того и забираем 1м, а это 1
        // push() добавление элемента в stack, заталкивать
        stack.push(5);
        stack.push(3);
        stack.push(1);
        // peek() просто отображает элемент из стека
        System.out.println(stack.peek());
        // pop() достает/извлекает/забирает последний добавленный элемент в наш stack
        System.out.println(stack.pop());
        // empty() - возврщает true если stack пустой или false если stack не пустой
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
}
