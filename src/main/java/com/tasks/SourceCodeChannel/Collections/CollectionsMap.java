package com.tasks.SourceCodeChannel.Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionsMap {

    // Map - позволяет сопостовлять значение с их уникальными ключами, посе того как значение будет сохранено,
    // доступ к нему может быть осуществлен по Ключу.

    // HashMap - реализован на основе Hash таблиц, ключи и значения HashMap могут быть любыми включая null,
    // поэтому четки порядок элементов не гарантируется, ключи должны быть уникальными в то время как значения
    // могут дублироватся

    // Чем отличается HashMap от HashTable? Методы HashTable синхронизированы что уменьшает производительность программы
    // для однопоточных приложений, так же в HashTable нельзя хранить в качестве ключей и значений обьекты null

    // LinkedHashMap - расширяет HashMap и создает связанный список элементов которые распологаются в порядке их
    // добавления, LinkedHashMap хоть и незначительно но все же медленее HashMap

    // TreeMap - хранит в коллекции ключи в отсрортированном порядке по возрастанию, в отличии от HashMap and LinkedHashMap
    // TreeMap не может содержать ключи со значением null

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        // Массив ключей элементы которого добавляем в хаотичном порядке
        int[] keys = new int[] {5, 3, 4, 1, 2, 0};
        String[] values = new String[] {"a", "b", "c", "e", "f"};

        for (int i = 0; i < values.length; i++) {
            // Добавляем через итерацию длины значений "values"
            treeMap.put(keys[i], values[i]);
        }
        // В цикле создадим обьект Map Entry, entrySet()- возвращает элементы коллекции
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Так как TreeMap наследует NavigableMap, у TreeMap есть возможность реализаци методов HeadMap and TailMap
        // данные методы аналогичны методам NavigableSet, HeadSet and TailSet
        // Будут выведенеы методы до treeMap.headMap(3));
        System.out.println("First half of TreeMap: " + treeMap.headMap(3));
        // Будут выведенеы методы до treeMap.tailMap(3));
        System.out.println("Second half of TreeMap: " + treeMap.tailMap(3));

    }

   /* public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(0, "RED");
        linkedHashMap.put(1, "GREEN");
        linkedHashMap.put(2, "GREY");

        // В цикле создадим обьект Map Entry, entrySet()- возвращает элементы коллекции
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            // В консоль КЛЮЧ и ЗНАЧЕНИЕ
            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

    }*/


   /* public static void main(String[] args) {
        // <Integer - КЛЮЧ, String - ЗНАЧЕНИЕ>
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(0,"Text 1");
        hashMap.put(1,"Text 2");

        // Получить значение по КЛЮЧУ через метод get()
        System.out.println(hashMap.get(0));
        System.out.println(hashMap.get(1));

        // Заменить элемент HashMap можду с помощью метода replace()
        hashMap.replace(0, "Text 3 Replaced");
        System.out.println(hashMap.get(0));

        // Удаляет элемент из HashMap по КЛЮЧУ
        hashMap.remove(0);
        System.out.println(hashMap);
    }*/
}
