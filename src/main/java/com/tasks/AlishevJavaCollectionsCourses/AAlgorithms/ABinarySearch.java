package com.tasks.AlishevJavaCollectionsCourses.AAlgorithms;

public class ABinarySearch {
    public static void main(String[] args) {
        // пример вызова метода
        int[] a = {-5, -2, 1, 5, 6, 8, 10, 20};
        System.out.println(binarySearchRecursive(a, 1, 0, a.length - 1)); // начальные low и high надо передавать в аргументы

        System.out.println(binarySearch(new int[]{-1, 2, 3, 5, 8, 10, 16, 20}, 7));
    }

    // [0, 1, 2, 3, 4, 5, 6]
    // [1, 2, 3, 4, 5, 6, 7]
    public static int binarySearch(int[] a, int key) {
        int low = 0; // 1й элемент
        int high = a.length - 1; // Последний элемент

        while (low <= high) { // (6 - 0) / 2 = 3, элемент №4
            int middle = low + (high - low) / 2;

            // Например если 5 < 4[3 индекс массива]
            if (key < a[middle]) {
                // тогда  high = значение[2 адрес] берем элемент слева от 4[3]
                high = middle - 1;
            } else if (key > a[middle]) {
                // и наоборот 5[4]
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] sortedArray, int key, int low, int high) {
        // считаем индекс центрального элемента
        int middle = low + (high - low) / 2;

        // base case (условие выхода) - регион поиска пустой
        if (low > high) {
            // не нашли элемента, который равен ключу
            return -1;
        }

        if (key == sortedArray[middle]) {
            // в случае, если элемент в центре равняется ключу (нашли элемент)
            return middle;
        } else if (key < sortedArray[middle]) {
            // рекурсивный вызов для левого подмассива
            // не забывайте здесь ключевое слово return (подумайте, зачем оно нужно)
            return binarySearchRecursive(sortedArray, key, low, middle - 1);
        } else {
            // рекурсивный вызов для правого помассива
            return binarySearchRecursive(sortedArray, key, middle + 1, high);
        }
    }
}