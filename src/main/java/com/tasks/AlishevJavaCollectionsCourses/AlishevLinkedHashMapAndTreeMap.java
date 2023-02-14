package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AlishevLinkedHashMapAndTreeMap {
    // Если просто "HashMap" то он самый быстрый, но если нам нужен порядок то нужно использовать
    // LinkedHashMap = сохраняет порядок добавления <key, value> в map И TreeMap = при добавлении сортирует ваши пары
    // <key, value> по key
    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>(); // Внутри не гарантируется никакого порядка
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // В каком порядке <key, value> были добавлены
        // в таком порядке они и вернутся
        Map<Integer, String> treeMap = new TreeMap<>(); // Пары <key, value> сортируются по key, (естественный порядок)
        // если Integer(сортировка от меньшего к большему, если String то сортировка лексикограчиеская,
        // то есть по алфавиту) и для своих обьектов?

        testMap(hashMap); // выводит произвольны порядок
        testMap(linkedHashMap); // вывел в порядке добавления map пары
        testMap(treeMap); // вывел в отсортированном порядке по key

    }

    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

      /*  Map<String, String> translations = new HashMap<>();

        translations.put("кошка", "cat");
        translations.put("собака", "dog");
        translations.put("слон", "elephant");

        for(Map.Entry entry : translations.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
*/

