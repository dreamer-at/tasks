package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AlishevSetOne {
    // Set хранит в себе набор только уникальных элементов, из математики множеств, если ли множество или нет
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>(); // Не сохраняет какого либо порядка, так же как и в HashMap
        Set<String> linkedHashSet = new LinkedHashSet<>(); // Сортируется в порядке добавления
        Set<String> treeSet = new TreeSet<>(); // Сортируются в соответсвии их естественному порядку (по алфивиту если строки)

        // HashSet самый быстрый но не будет сохранять ни "порядка в котором добавляли элементы"
        // НИ "естественного порядка, по алфавиту или по цифрам сортировка"
        // Но все они хранят только уникальные значения
        hashSet.add("You");
        hashSet.add("Best");
        hashSet.add("Creator");
        hashSet.add("Our");
        hashSet.add("System");

        for(String nameHashSet : hashSet) {
            System.out.println(nameHashSet);
        }

        // LinkedHashSet будет сортировать согласно порядку в котором добавляли элементы
        linkedHashSet.add("You");
        linkedHashSet.add("Best");
        linkedHashSet.add("Creator");
        linkedHashSet.add("Our");
        linkedHashSet.add("System");

        System.out.println();
        for (String nameLinkedHashSet : linkedHashSet) {
            System.out.println(nameLinkedHashSet);
        }

        // TreeSet будет сортировать согласно естественному порядку
        treeSet.add("You");
        treeSet.add("Best");
        treeSet.add("Creator");
        treeSet.add("Our");
        treeSet.add("System");

        System.out.println();
        for (String nametreeSet : treeSet) {
            System.out.println(nametreeSet);
        }
    }
}
