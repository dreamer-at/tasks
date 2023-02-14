package com.tasks.AlgorithmsDataStructures;

public class KiteSchoolSelection {

    public static void main(String[] args) {
        // Sort
        // Selection
        int[] arr = {12,2,4,5,0,1, 0 , 0, 234};
        arr = sort(arr);
        for(int number : arr){
            System.out.println(number);
        }
    }
    static int[] sort(int[] arr){
        for(int i=0; i<arr.length;i++){
            int min = i;
            // j=i+1; j всегда на 1 шаг впереди i, сравнение 2х элементов
            for(int j=i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min=j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }
}
