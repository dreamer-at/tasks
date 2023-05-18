package com.tasks.LeetCode.DataStructuresAndAlgorithms.ArraysAndStrings;

public class EasyMinimumValueToGetPositiveStepByStepSum {

    // Given an array of integers nums, you start with an initial positive value startValue.
    // In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
    // Return the minimum positive value of startValue such that the step by step sum is never less than 1.
    public static void main(String[] args) {

        int[] nums = {-3, 2, -3, 4, 2}; // 5
        int[] nums1 = {1, 2}; // 1
        int[] nums2 = {1, -2, -3}; // 5

        System.out.println(minStartValueBinarySearchPrefixTotal(nums));
        System.out.println(minStartValueBinarySearchPrefixTotal(nums1));
        System.out.println(minStartValueBinarySearchPrefixTotal(nums2));
    }

    // Time: O(n)
    // Space: O(1)
    private static int minStartValueBinarySearchPrefixTotal(int[] nums) {
        // How to find the minimum positive number through which if you pass the entire array
        // will it stay > 0? i.e. positive
        // This is to find the minimum number and add 1 to it
        // We use "total" for current step-by-step total, "minVal" for minimum
        // step-by-step total among all sums. Since we always start with startValue = 0
        // therefore the initial current step-by-step total is 0
        // thus we set "total" and minVal be 0.
        int min = 0, sum = 0;

        // Iterate over the array and get the minimum step-by-step total.
        for (int n : nums) {
            sum += n;
            min = Math.min(min, sum);
        }
        // We have to let the minimum step-by-step total equals to 1,
        // by increasing the startValue from 0 to -minVal + 1,
        // which is just the minimum startValue we want.
        // -minVal - minus make it positive like Math.abs
        return 1 - min; // Why + 1, because 1 is the first positive number after 0
    }

    // Time: O(n⋅log(mn)) - n length of array * log(m sum in each index of array * n length of array)
    // Space: O(1)
    private static int minStartValueBinarySearch(final int[] nums) {
        // Let n be the length of array "nums", m be the absolute value
        // of the lower boundary of the element. In this question we have m = 100
        int n = nums.length;
        int m = 100;

        // Set left and right boundaries according to left = 1, right = m * n + 1
        int left = 1;
        int right = m * n + 1;
        while (left < right) {
            // Get middle index "middle" of the two boundaries, let the start value be "middle"
            // The initial step-by-step total "total" equals to middle as well.
            // Use boolean parameter "isValid" to record whether the total is grater or equal to 1
            int middle = (left + right) / 2;
            int total = middle;
            boolean isValid = true;
            // Iterate over the array "nums"
            for (int num : nums) {
                // In each iteration, calculate "total" plus the element "num" in the array.
                total += num;
                // If "total" is less than 1, we shall try larger start value, we mark "isValid" as "false"
                // and break the current iteration.
                if (total < 1) {
                    isValid = false;
                    break;
                }
            }
            // Check if middle is valid, and reduce the search space by half.
            if (isValid) {
                right = middle;
            } else { // if total < 1, we increase our left
                left = middle + 1;
            }
        }
        // When the left and right boundaries coincide, we have found
        // the largest value, that is, the minimum valid startValue.
        return left;
    }

    // Time: O(n2⋅m)
    // Space: O(1)
    private static int minStartValueBruteForce(final int[] nums) {
        // Start with startValue = 1;
        int startValue = 1;
        // While we haven't found the first valid startValue
        while (true) {
            // The step-by-step total equals startValue at the beginning.
            // Use boolean parameter "isValid" to record whether the total
            // is larger than or equal to 1
            int total = startValue;
            boolean isValid = true;

            // Iterate over the array "nums"
            for (int num : nums) {
                // In each iteration, calculate total plus the element "num" in the array
                total += num;
                // if total is less than 1, we shall try a larger we mark "isValid" as "false" and break the current
                // iteration
                if (total < 1) {
                    isValid = false;
                    break; // break for loop cycle
                }
            }
            // If "isValid" is true, meaning "total" is never less than 1 in iteration, therefore we return this
            // "startValue"
            // Otherwise, we go ahead and try "startValue" + 1 as the new "startValue".
            if (isValid) {
                return startValue; // It this case all cycle already iterated
            } else {
                startValue += 1;
            }
        }
    }
}
