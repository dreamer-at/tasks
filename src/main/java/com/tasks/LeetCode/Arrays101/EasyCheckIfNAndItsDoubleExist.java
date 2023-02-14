package com.tasks.LeetCode.Arrays101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyCheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        int[] arr0 = {10, 2, 5, 3}; // true
        int[] arr1 = {3, 1, 7, 11}; // false
        int[] arr2 = {-16, -13, 8}; // false
        int[] arr3 = {7, 1, 14, 11}; // true
        int[] arr4 = {-20, 8, -6, -14, 0, -19, 14, 4}; // true
        int[] arr5 = {-2,0,10,-19,4,6,-8}; // false

        System.out.println(checkIfExistSet(arr0));
        System.out.println(checkIfExistSet(arr1));
        System.out.println(checkIfExistSet(arr2));
        System.out.println(checkIfExistSet(arr3));
        System.out.println(checkIfExistSet(arr4));
        System.out.println(checkIfExistSet(arr5));
    }

    // Check If N and Its Double Exist
    // Given an array arr of integers, check if there exist two indices i and j such that :
    // i != j
    // 0 <= i, j < arr.length
    // arr[i] == 2 * arr[j]

    // Example 1:
    // Input: arr = [10,2,5,3]
    // Output: true
    // Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
    // Example 2:
    // Input: arr = [3,1,7,11]
    // Output: false
    // Explanation: There is no i and j that satisfy the conditions.

    // Loop from i = 0 to arr.length, maintaining in a hashTable the array elements from [0, i - 1].
    // On each step of the loop check if we have seen the element 2 * arr[i] so far or arr[i] / 2 was seen if arr[i]
    // % 2 == 0.

    private static boolean checkIfExistSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (final int j : arr) {
            if (j % 2 == 0 && set.contains(j / 2) || set.contains(j * 2)) {
                return true;
            }
            set.add(j);
        }
        return false;
    }

    public static boolean checkIfExistMap(int[] arr) {
        if (arr.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 0; i < arr.length; i++) {
            int dub = arr[i] * 2;
            if (map.containsKey(dub) && map.get(dub) != i) {
                return true;
            }
        }
        return false;
    }
}

