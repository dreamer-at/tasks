package com.tasks.AGrokkingAlgorithms.AMyCODE;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrQuickSort {
    public static void main(String[] args) {
       List<Integer> ar = Arrays.asList(10, 5, 2, 3);

        System.out.println(quicksort(ar));
    }

    private static List<Integer> quicksort(List<Integer> list) {
        if(list.size() < 2) {
            return list; // Базовый случай, массивы с элементами 0 и 1 уже отсортированы
        } else {
            // Рекурсивный случай
            Integer pivot = list.get(0);

            // Подмассив всех элементов меньше чем опорный элемент pivot
            List<Integer> less = list.stream().skip(1).filter(el -> el <= pivot)
                    .collect(Collectors.toList());

            // Подмассив всех элементов больше чем опорный элемент
            List<Integer> greater = list.stream().skip(1).filter(el -> el > pivot)
                    .collect(Collectors.toList());

            return Stream.of(
                    quicksort(less).stream(),
                    Stream.of(pivot),
                    quicksort(greater).stream())
                    .flatMap(Function.identity()).collect(Collectors.toList());
        }
    }
}
