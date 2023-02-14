package com.tasks.AlgorithmsDataStructures;

public class IntegerArraySum {
    public static void main(String[] args) {
        int [] integerArray = {10,6,4,23,87,1,12,1004};

        int sum = 0;

        for (int i = 0; i < integerArray.length; i++){
            sum += integerArray[i];
        }
        System.out.println(sum);
    }
}
//В данном случае, количество операция напрямую зависит от количества элементов в массиве.
// Т.е. если у нас 10 элементов – мы должны получить досутп к массиву и выполнить операцию сложения 10 раз. Если 100 элементов – 100 раз.
//Такая сложность, называется линейной и обозначается O(n).