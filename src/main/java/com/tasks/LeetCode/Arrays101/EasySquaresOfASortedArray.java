package com.tasks.LeetCode.Arrays101;

import java.util.Arrays;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasySquaresOfASortedArray {

    public static void main(String[] args) {

        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(sortedSquaresSol2(nums)));
    }

    // Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number
    // sorted in non-decreasing order.
    // Input: nums = [-4,-1,0,3,10]
    // Output: [0,1,9,16,100]
    // Explanation: After squaring, the array becomes [16,1,0,9,100].
    // After sorting, it becomes [0,1,9,16,100].

    // Approach 1: Sort
    // Intuition and Algorithm
    // Create an array of the squares of each element, and sort them.

    // Complexity Analysis
    // Time Complexity: O(N log N), where N is the length of A and because of sort O(n log(n)) where O(n)-loop * log(n) sort
    // OR we do not take into account loop complexity O(n) and take only Arrays.sort as main complexity parameter
    // Why we take into account only Arrays.sort complexity? Because it is matter on big data,
    // and we don't take into account loop with O(n)

    // Space complexity : O(N) or O(log N)
    //     - The space complexity of the sorting algorithm depends on the implementation of each program language.
    //     - For instance, the list.sort() function in Python is implemented with the Timsort algorithm whose space
    //       complexity is O(N).
    // In Java, the Arrays.sort() is implemented as a variant of quicksort algorithm whose space complexity is O(logN)
    // Arrays.sort uses dual-pivot Quicksort on primitives. It offers O(n log(n))
    // Mergesort algorithm for Array of Objects

    private int[] sortedSquaresSol1(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i) {
            ans[i] = A[i] * A[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    // Approach 2: Two Pointer
    // Intuition
    // Since the array A is sorted, loosely speaking it has some negative elements with squares in decreasing order,
    // then some non-negative elements with squares in increasing order.
    // For example, with [-3, -2, -1, 4, 5, 6], we have the negative part [-3, -2, -1] with squares [9, 4, 1],
    // and the positive part [4, 5, 6] with squares [16, 25, 36].
    // Our strategy is to iterate over the negative part in reverse, and the positive part in the forward direction.

    // Algorithm
    // We can use two pointers to read the positive and negative parts of the array -
    // one pointer j in the positive direction, and another i in the negative direction.

    // Now that we are reading two increasing arrays (the squares of the elements),
    // we can merge these arrays together using a two-pointer technique.

    // Complexity Analysis
    // Time Complexity: O(N), where N is the length of A.
    // Space Complexity: O(N) if you take output into account and O(1) otherwise.

    private static int[] sortedSquaresSol2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            int square;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }

    private int[] sortedSquaresSelfSol(int[] nums) {
        int n = nums.length;
        int idx = n - 1;
        int l = 0, r = n - 1;

        int[] ans = new int[n];

        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                ans[idx] = nums[l] * nums[l];
                l++;
            } else {
                ans[idx] = nums[r] * nums[r];
                r--;
            }

            idx--;
        }

        return ans;
    }
}
