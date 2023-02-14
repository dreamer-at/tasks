package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashSet;
import java.util.Set;

public class AlishevSetTwo {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Arnold");
        hashSet.add("Bob");
        hashSet.add("Tom");
        hashSet.add("Donald");
        hashSet.add("Jessica");

        System.out.println(hashSet.contains("Tom")); // contains = boolean, есть или нет в этом set элемент
        System.out.println(hashSet.contains("Tim")); // этот метод самый быстрый в Set

        System.out.println(hashSet.isEmpty()); // Пустой или нет



    }
}
