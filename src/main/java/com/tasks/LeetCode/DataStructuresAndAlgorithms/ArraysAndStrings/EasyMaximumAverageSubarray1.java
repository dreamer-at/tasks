package com.tasks.LeetCode.DataStructuresAndAlgorithms.ArraysAndStrings;

public class EasyMaximumAverageSubarray1 {

    // Maximum Average Subarray I
    // Solution
    // You are given an integer array nums consisting of n elements, and an integer k.
    // Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    // Any answer with a calculation error less than 10-5 will be accepted.
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3}; // 12.75000
        int k = 4;

        int[] nums1 = {5}; // 5.00000
        int k1 = 1;

        System.out.println(findMaxAverageBest(nums, k));
        System.out.println(findMaxAverageBest(nums1, k1));
    }


    // Time: O(n)
    // Space: O(1)
    private static double findMaxAverage(final int[] nums, final int k) {
        double res = 0.0;

        for (int i = 0; i < k; i++) {
            res += nums[i];
        }

        double temp = res;
        for (int i = k; i < nums.length; i++) {
            temp += nums[i] - nums[i - k];
            res = Math.max(res, temp);
        }
        return res / k;
    }

    // Time: O(n)
    // Space: O(1)
    private static double findMaxAverageBest(int[] nums, int k) {
        int sum = 0;
        int max;

        for (int i = 0; i < k; i++) {
            sum = sum + nums[i];
        }
        max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            max = Math.max(max, sum);

        }
        return (double) (max) / k;
    }
}
