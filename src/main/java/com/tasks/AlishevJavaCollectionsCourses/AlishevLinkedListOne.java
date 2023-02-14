package com.tasks.AlishevJavaCollectionsCourses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AlishevLinkedListOne {
// Метод remove() считается сильной отличительной стороной у LinkedList в отличии от ArrayList
// Если нужно много записывать в конец листа, если нужно много считывать из листа == ArrayList
// Если вы производите удаление элементов из листа или добавление элементов в начало листа == LinkedList
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        // LinkedList как двусвязный список head -> [1] -> [2] -> [3] -> [4] -> [5] при добавлении меняем ссылк и== вставка в начало быстрее
        // Элемент и ссылка на следующий узел add, добавить быстро
        // get медленный у ArrayList быстрее за счет массива

        // Если мы хотим просто добавлять элементы, то лучше всего использовать ArrayList
        // Но из за того что он сделан на основе массива, то при каждом удалении создается новый массив
        // Удаление в начале и в середине будет медленее (удаляя переклеивает массив), добавление быстрее потому что добавляет с конца
        // ArrayList [1][2][3][4][5] - добавление идет в конце и быстро, добавление в начало медленее, потому что все элементы
        // нужно будет сдвигать вправо
        List<Integer> arrayList = new ArrayList<>();

        measureTime(linkedList);
        measureTime(arrayList);
    }

    private static void measureTime(List<Integer> list) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            list.add(0, i); // в начало linkedList листа 3 секунды быстрее
        }

        for(int i = 0; i < 100000; i++) {
            list.get(i); // Быстрее у ArrayList
        }


        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
