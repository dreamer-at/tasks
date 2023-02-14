package com.tasks.AGrokkingAlgorithms.AMyCODE;

import java.util.Arrays;

public class GrFactorial {

    public static void main(String[] args) {
        int fL = 4;
        int[] s = {1, 2, 3, 4};
        int sR = 4;


        System.out.println(factorial(fL));
       /* System.out.println(recCount(s));
        System.out.println(recCountSum(s));
        System.out.println(recursiveMax(s));
        System.out.println(recSum(sR));*/
    }

    public static int factorial(int x) {

        if (x <= 1) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }

    // Сумма всех чисел простым сложением
    public static int sum(int[] n) {
        int sum = 0;
        for (int value : n) {
            sum += value;
        }
        return sum;
    }

    // Сумма всех чисел рекурсией
    public static int recSum(int n) {
        int res = 1;
        if (n <= 1) {// поиск базового случая 1
            return res;
        } else { // Хотим вычислить сумму всех чисел, но для этого пройдемся по всей сумме до 1
            // + не делаем пока не достигнем базового случая 1
            res = n + recSum(n- 1);//  n - 1 это поиск базового случая рекурсией
        }
        return res;
        // Сначала прочитали/записали все до базового случая 1, а потом в обратном порядке обьеденили те же цифры
        // 4 3 2 1 == 1 + 2 + 3 + 4 = 10 сумма всех чисел
        // 4 -> 6 + 4 = 10
        // 3 -> 3 + 3 = 6
        // 2 -> 2 + 1 = 3
        // 1 ->
    }

    private static int recCount(int[] list) {
        if (list.length == 0) {
            return 0;
        }
        return 1 + recCount(Arrays.copyOfRange(list, 1, list.length));
    }

    private static int recCountSum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] + recCountSum(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    private static int recursiveMax(int[] list) {
        if (list.length == 2) {
            return list[0] > list[1] ? list[0] : list[1];
        }

        int subMax = recursiveMax(Arrays.copyOfRange(list, 1, list.length));
        return list[0] > subMax ? list[0] : subMax;
    }
}
