package com.tasks.AlishevJavaCollectionsCourses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlishevArrayList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            list.add(i); // Создали и итерируемся из ArrayList
        }
        list.remove(5);
        System.out.println(list);

        // Мы проводим много удалений из нашего листа
        list = new LinkedList<>(); // Удаляем много и используем LinkedList




   /*     System.out.println(arrayList);

        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(99));

        for(int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        for(Integer x : arrayList) {
            System.out.println(x);
        }*/
        // Метод "remove" медленный если удаление массива происходит посередине или ближе к началу

    }
}
