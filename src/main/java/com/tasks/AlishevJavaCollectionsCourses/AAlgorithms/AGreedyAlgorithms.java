package com.tasks.AlishevJavaCollectionsCourses.AAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class AGreedyAlgorithms {
    public static void main(String[] args) {
        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.println(maxNumberFromDigitsWithStream(digits));
    }

    public static String maxNumberFromDigitsOldVersion(int[] digits) {
        // {3, 1, 7, 9, 9, 5} -> {1, 3, 5, 7, 9, 9}
        // Сложность алгоритма сортировки "Quicksort" -  O(n*log(n))
        // Конактинация всех цифр в массиве , сложность алгоритма - O(n)
        // Конечная сложность алогритма - O(n*log(n))
        Arrays.sort(digits);

        String result = "";

        // length - 1 - обращаемся в начале к последнему элементу массива
        // [length - 1] - это и есть индекс/адрес последнего элемента в массиве
        // i >= 0; i-- - Пока i не будет больше или равна 0, отнимать от конца массива -1
        for (int i = digits.length - 1; i >= 0; i--) {
            // Каждый раз инкреминтируя i, мы в result записываем все элементы масива,
            // в [i] указываем индекс и через этот индекс итерируем весь массив и записываем в result
            result += digits[i]; // После сортировки массива по возрастанию, в result мы записываем самые большие цифры
            // с конца, тем самым реализоваа жадный алгоритм
        }
        return result;
    }

    public static String maxNumberFromDigitsWithStream(int[] digits) {
       return  String.join("", Arrays.stream(digits) // join принимает разделитель "" и массив Arrays.
               // и склеивает их на основании "" разделителя
               .boxed() // оборачиваем в класс обертку Integer, потому что будем использовать Comparator, CompareTo
               .sorted(Collections.reverseOrder()) // Сортирует в обратном порядке
               .map(String::valueOf) // Переводим числа в строки
               .toArray(String[]::new)); // перевести наш Stream в массив строк
    }
}
