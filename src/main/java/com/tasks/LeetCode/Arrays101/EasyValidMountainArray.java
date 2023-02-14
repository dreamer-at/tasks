package com.tasks.LeetCode.Arrays101;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyValidMountainArray {

    public static void main(String[] args) {
        int[] arr1 = {2, 1};
        int[] arr2 = {3, 5, 5};
        int[] arr3 = {0, 3, 2, 1};

        //System.out.println(validMountainArray(arr1));
        //  System.out.println(validMountainArray(arr2));
        System.out.println(validMountainArray(arr2));
        System.out.println(validMountainArray(arr3));
    }

    // Example 1:
    // Input: arr = [2,1]
    // Output: false
    // Example 2:
    // Input: arr = [3,5,5]
    // Output: false
    // Example 3:
    // Input: arr = [0,3,2,1]
    // Output: true

    // Given an array of integers arr, return true if and only if it is a valid mountain array.
    // Recall that arr is a mountain array if and only if:
    // arr.length >= 3
    // There exists some i with 0 < i < arr.length - 1 such that:
    // arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    // arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

    // Approach 1: One Pass
    // Intuition
    // If we walk along the mountain from left to right, we have to move strictly up, then strictly down.

    // Algorithm
    // Let's walk up from left to right until we can't: that has to be the peak. We should ensure the peak is not the
    // first or last element. Then, we walk down. If we reach the end, the array is valid, otherwise it's not.

    // Complexity Analysis
    // Time Complexity: O(N), where N is the length of A.
    // Space Complexity: O(1).

    private static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        if (n < 3) {
            return false;
        }

        // walk up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // peak can't be first or last index of array
        if (i == 0 || i == n - 1) {
            return false;
        }

        // we reached the peak and walk down - count steps down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        // compare i - counted sum of steps or indexes with remained of indexes of arr - 1 = sum on indexes
        return i == n - 1;
    }

    private static boolean validMountainArray1(int[] arr) {
        if (arr == null || arr.length < 3) {
            return false;
        }

        boolean increasing = arr[1] > arr[0];
        if (!increasing) {
            return false; // the mountain must at least start in an increasing manner
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false; // plateaus are prohibited
            }
            if (increasing) {
                if (arr[i] < arr[i - 1]) {
                    increasing = false; // we reached the peak
                }
            } else { // every element must be decreasing, otherwise return false
                if (arr[i] > arr[i - 1]) {
                    return false;
                }
            }
        }

        // we can't just return true, we must ensure that a peak was reached at some point.
        return !increasing;
    }
}
