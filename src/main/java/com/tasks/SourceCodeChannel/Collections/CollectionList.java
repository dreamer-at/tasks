package com.tasks.SourceCodeChannel.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class CollectionList {

    // List в отличии от коллекции Set, List может содержать повторяющиеся элементы
    // Обощенные реализации это - ArrayList and LikedList
    // ArrayList - массивом количества элементов, длина которого не постоянна динамически изменяется во время
    // добавления новых элементов
    // LinkedList - является двусвязным списком, это означает что список состоит из узлов, которые помимо исходных элементов
    // в позиции содержат ссылки на предыдущие и следующие узлы списка.

    // Все различие между ArrayList and LinkedList заключается в скорости работы с элементами и в потреблении памяти
    // ArrayList в большинстве случаев работает быстрее чем LinkedList и экономичнее потребляет память, однако когда речь
    // идет о вставке или удалении элементов не включая поиск самой позиции вставки или удаления элементов
    // то LinkedList справляется быстрее

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        String[] strings = new String[]{"b", "c", "d"};

        // addAll добавляем в list все strings массив
        Collections.addAll(list, strings);
        System.out.println(list);
        // Добавим в начало списка какой нибудь элемент
        list.addFirst("Y");
        System.out.println(list);
        // Добавим в КОНЕЦ списка какой нибудь элемент
        list.addLast("Z");
        System.out.println(list);

        // Получить 1й и последный элемент из списка
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        // Удалить 1й и последний элемент
        list.removeFirst();
        list.removeLast();
        System.out.println(list);



       /* ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        // Удаляет элемент в указанной позиции
        // Тут возвращает обьект который был удален
        System.out.println(list.remove(0));*/
        /*// Метод get позволяет получить элемент в указанной позиции
        System.out.println(list.get(0));
        // java.lang.IndexOutOfBoundsException: Index: 1, Size: 1
        System.out.println(list.get(1));*/

        /*list.add(7);
        // метод set изменить значение обьекта в указанной позиции
        list.set(0, 5);
        System.out.println(list);

        // Получим необработанное исключение "Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1, Size: 1"
        // Потому что пытаемся получить несуществующий элемент в несуществующей позиции
        list.set(1, 9);
        System.out.println(list);*/

       /* ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);

        System.out.println(list);

        // Добавляем индекс и элемент
        list.add(0, 0);
        list.add(3, 3);

        System.out.println(list);

        ArrayList<Integer> nextList = new ArrayList<>();

        nextList.add(4);
        // Добавить элементы из другого списка
        nextList.addAll(list);
        System.out.println(nextList);

        nextList.addAll(0, list);
        System.out.println(nextList);*/
    }
}
