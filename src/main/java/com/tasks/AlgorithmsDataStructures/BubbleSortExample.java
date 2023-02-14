package com.tasks.AlgorithmsDataStructures;

public class BubbleSortExample {

    public static void main(String[] args) {
        Integer[] array = {1, 34, 35, 128, 9810, 0, 22, 75, -5};

        for (int i = 0; i < array.length; i++) {
            int numBegin = array[i];

            // Идем по массиву в обратном порядке
            for (int j = i - 1; j >= 0; j--) {
                int rightNumber = array[j];

                // Если числа с левой части меньше чем числа с правой части
                // то массив i ссева присваиваем = правой части и наоборот
                if (numBegin < rightNumber) {
                    array[j+1] = rightNumber;
                    array[j] = numBegin;
                } else {
                    break;
                }
            }
        }
       for (Integer n : array) {
           System.out.println(n + ",");
       }
    }
}
