package com.tasks.AlgorithmsDataStructures;

public class BinarySearch {
    public static void main(String[] args) {
        int[] integerArray = {-183, 12, 15, 40, 234, 345, 800, 977800, 345, 977};
        int elementToFind = 977800;
        System.out.println("Element " + elementToFind + " found, index: " + binarySearch(integerArray,
                elementToFind, 0, integerArray.length -1));
    }

    public static int binarySearch(int[] sortedIntegerArray, int elementToFind, int low, int high){
        if (low > high){
            // Зачем в 1м примере возвращать -1?Так как в массиве не может быть отрицательного индекса - это явно сигнализирует о том,
            // что элемента с таким значения в массиве нет. И без логирования и исключений мы это можем показать именно таким способом.
            return -1;
        }

        int mid =low + (high - low)/2;

        if (elementToFind < sortedIntegerArray[mid]){
            return binarySearch(sortedIntegerArray, elementToFind, low, mid -1);
        } else if (elementToFind > sortedIntegerArray[mid]) {
            return binarySearch(sortedIntegerArray, elementToFind, mid +1, high);
        } else {
            return mid;
        }
    }
}
//В данном примере происходит следующее:
//В методе binarySearch мы принимаем упорядоченный (отсортированный) массив целых чисел.
//Проверяем, чтобы low был меньше high (low = 0, high = 9) – получаем false
//Получаем середину массива – 234
//Сравниваем 234 и искомым значением 977800 – 977800 больше.
//Отсекаем левую часть массива и получаем новые low – 5 и high – 9.
//Новая медиана – 977800
//Попадаем в условие else – возвращаем индекс 7.
//Наиболее важным, при выборе алгоритма, должно быть понимание того, как он работает и какие имеет сильные и слабые стороны.