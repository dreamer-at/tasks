package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AlishevSetThree {

    public static void main(String[] args) {

        // union - обьединения множества, получаем элементы множества a и множества b без дубликатов, обьединяя их
        Set<Integer> set1 = new HashSet<>();
        set1.add(0);
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2); // в union содержатся числа множества set1 и set2
        System.out.println(union); // выводим на экран не дублирующийся множества из set1 и set2

        // intersection - пересечение множества, получаем элементы из множества "a" которые имеются в множестве "b"
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2); // retainAll - делает пересечение множеств, то что есть в set1 выбирает из set2
        System.out.println(intersection);

        // difference - разность множества, из множества a убираем все элементы которые присутствуют в множестве b
        Set<Integer> difference = new HashSet<>(set1);
        difference.removeAll(set2); // removeAll полная противоположность retainAll, из set1 удаляются все элементы которые
        // присутствуют в set2
        System.out.println(difference);


    }
}
