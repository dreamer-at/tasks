package com.tasks.SourceCodeChannel.Collections;

import java.util.*;

public class CollectionsSet {
    // В Set запрещены одинаковые элементы
    // Коллекция Set описывает неупорядоченно множество элементов которые не повторяются
    // SortedSet - определяет поведение мношеств которые острортированы по возрастанию
    // TreeSet - Хранит элементы в виде дерева в отсортированном порядке
    // LinkedHashSet - добавляются элементы в таком порядке в котором они добавляются
    // HashSet - инкапсулирует обьект HashMap который используют для хранения данных в Hash Таблицу
    // в HashSet каждый элемент есть уникальным ключем, а значение обьекта, упорядоченность элементов не гарантируется

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 0, 5, 8, 6};
        Set<Integer> dataSet = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            dataSet.add(array[i]);
        }
        System.out.println(dataSet.toString());
    }
}

   /* public static void main(String[] args) {

        int[] array = {0, 1, 2, 3, 4, 5};
        Set<Integer> linkedHashSet = new LinkedHashSet<>();

        for (int i = 0; i < array.length; i++) {
            linkedHashSet.add(array[i]);
        }

        Iterator iterator = linkedHashSet.iterator();

        for (int i = 0; i < array.length; i++) {
            System.out.println(iterator.next());
        }
*/

     /*   int[] array = {0, 1, 2, 3, 4, 5};
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < array.length; i++) {
            treeSet.add(array[i]);
        }
        System.out.println("Size of current TreeSet: " + treeSet.size());

        for (int i = 0; i < array.length / 2; i++) {
            treeSet.remove(array[i]);
        }
        System.out.println("TreeSet after removing: " + treeSet.toString());*/

       /* SortedSet<Integer> numberSet = new TreeSet<>();

        int[] array = new int[] {9, 1, 7, 6, 2, 0, 3, 8, 5, 4};

        for (int i = 0; i < array.length; i++) {
            numberSet.add(i);
        }
        System.out.println("First element: " + numberSet.first());
        System.out.println("Last element: " + numberSet.last() + "\n");

        SortedSet<Integer> subset = numberSet.subSet(0, 4);

        System.out.println("Subset from 0 to 3: " + subset + "\n");
        System.out.println("First element of subset: " + subset.first());
        System.out.println("Last element of subset: " + subset.last() + "\n");*/

      /* int[] array = new int[] {0, 1, 2, 3, 4, 5};

       NavigableSet<Integer> navigableSet = new TreeSet<>(); {

           for (int navigableArray : array) {
               navigableSet.add(navigableArray);
           }
            System.out.println("lower(): " + navigableSet.lower(5));
            System.out.println("higher(): " + navigableSet.higher(3));
            System.out.println("floor(): " + navigableSet.floor(4));
            System.out.println("celling(): " + navigableSet.ceiling(4));

            Iterator iterator = navigableSet.descendingIterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next() + " ");
            }
       }*/

