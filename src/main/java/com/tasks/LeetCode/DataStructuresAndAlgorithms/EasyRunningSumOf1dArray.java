package com.tasks.LeetCode.DataStructuresAndAlgorithms;

import java.util.Arrays;

public class EasyRunningSumOf1dArray {

    public static void main(String[] args) {
        // Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
        // Return the running sum of nums.

        int[] nums = {1, 2, 3, 4}; // [1,3,6,10]
        int[] nums1 = {1, 1, 1, 1, 1}; // [1,2,3,4,5]
        int[] nums2 = {3, 1, 2, 10, 1}; // [3,4,6,16,17]

        System.out.println(Arrays.toString(runningSum(nums)));
        System.out.println(Arrays.toString(runningSum(nums1)));
        System.out.println(Arrays.toString(runningSum(nums2)));
    }

    private static int[] runningSum(final int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
