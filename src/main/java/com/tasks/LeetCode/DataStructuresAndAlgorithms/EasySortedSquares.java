package com.tasks.LeetCode.DataStructuresAndAlgorithms;

import java.util.Arrays;

public class EasySortedSquares {

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] nums1 = {-7, -3, 2, 3, 11}; // [4,9,9,49,121]

        System.out.println(Arrays.toString(sortedSquaresBest(nums)));
        System.out.println(Arrays.toString(sortedSquaresBest(nums1)));
    }

    // Time: O(n log n)
    // Space: O(n)
    private static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; ++i) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    // Approach 2: Two Pointer
    // Time: O(n)
    // Space: O(n)
    private static int[] sortedSquaresBest(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        // i-- Why? To create array in non-decreasing order from the end
        for (int i = n - 1; i >= 0; i--) {
            int sq;
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                sq = nums[right];
                right--;
            } else {
                sq = nums[left];
                left++;
            }
            res[i] = sq * sq;
        }
        return res;
    }


}
