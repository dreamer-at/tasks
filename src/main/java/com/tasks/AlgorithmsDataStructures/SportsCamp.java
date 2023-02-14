package com.tasks.AlgorithmsDataStructures;

public class SportsCamp
{
    public static void main(String[] args)
    {
        int nums [] = {6, 8, 3, 7, 5, 6, 1, 4};
        int val = 5;

        // use for-each style for to search nums for val
        for(int x: nums){
            if(x == val){
               System.out.println("Value found!" +  x);
            }
        }
    }
}
