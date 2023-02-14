package com.tasks.LeetCode.Arrays101;

import java.util.Arrays;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] arr1 = {400};

        System.out.println(Arrays.toString(replaceElements(arr)));
        System.out.println(Arrays.toString(replaceElements(arr1)));
    }

    // Given an array arr, replace every element in that array with the greatest element among the elements to its
    // right, and replace the last element with -1.
    // After doing so, return the array.

    // Example 1:
    // Input: arr = [17,18,5,4,6,1]
    // Output: [18,6,6,6,1,-1]
    // Explanation:
    // - index 0 --> the greatest element to the right of index 0 is index 1 (18).
    // - index 1 --> the greatest element to the right of index 1 is index 4 (6).
    // - index 2 --> the greatest element to the right of index 2 is index 4 (6).
    // - index 3 --> the greatest element to the right of index 3 is index 4 (6).
    // - index 4 --> the greatest element to the right of index 4 is index 5 (1).
    // - index 5 --> there are no elements to the right of index 5, so we put -1.

    // Example 2:
    // Input: arr = [400]
    // Output: [-1]
    // Explanation: There are no elements to the right of index 0.

    private static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int end = -1;

        if (1 == n) {
            arr[0] = end;
            return arr;
        }

        int m = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = m;
            m = Math.max(m, temp);
        }
        arr[n - 1] = end;
        return arr;
    }

    private static int[] replaceElementsWithAddMem(int[] arr) {
        int end = -1;
        int n = arr.length;

        if (1 == n) {
            arr[0] = end;
            return arr;
        }

        int[] res = new int[n];
        res[n - 1] = end;
        int m = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            res[i] = m;
            m = Math.max(m, arr[i]);
        }
        return res;
    }

}
