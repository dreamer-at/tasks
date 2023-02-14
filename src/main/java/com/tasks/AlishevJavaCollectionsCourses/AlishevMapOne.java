package com.tasks.AlishevJavaCollectionsCourses;

import java.util.HashMap;
import java.util.Map;

// Объект, который отображает ключи на значения. Карта не может содержать дубликаты ключей;
// каждая клавиша может отображать не более чем с одним значением.
public class AlishevMapOne {
    public static void main(String[] args) {
        // Используйте HashMap в том случае когда вам не важен какой либо порядок, вы поместили обьекты в HashMap
        // и при извлечении вам не важен порядок в каком вы помещали их, А ЕСЛИ ВЫ хотите отсортировать порядок
        // <key, value> то лучше использовать другие классы которые реализуют интерфейс map
        // Элементы в парах <ключ, значение> HashMap не имеют какого либо порядка
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Один");
        map.put(2, "Два");
        map.put(3, "Три");

        // Проходим по элементам map, сначала параметризуем "entry" и "map.entrySet()", берем все значения
        // Класс HashMap не гарантирует порядок
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
/*
        System.out.println(map);

        // В Map не может быть дубликатов значений, старое значение будет переписыватся
        map.put(3, "Another value for key #3");
        System.out.println(map);

        // Получить значение по Ключу
        System.out.println(map.get(1));
        // Если значение отсутсвует в map то возвращается null
        System.out.println(map.get(10));
*/
    }
}
