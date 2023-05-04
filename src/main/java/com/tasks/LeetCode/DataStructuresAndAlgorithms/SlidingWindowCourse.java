package com.tasks.LeetCode.DataStructuresAndAlgorithms;

public class SlidingWindowCourse {

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        String s = "1101100111";

        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;

        int[] nums2 = {3, -1, 4, 12, -8, 5, 6};
        int k2 = 4;

        System.out.println(findLengthTwo(s));
    }

    // Example 1: Given an array of positive integers nums and an integer k,
    // find the length of the longest subarray whose sum is less than or equal to k.
    // Time: O(n)
    // Space: O(n)
    private static int findLengthOne(int[] nums, int k) {
        int left = 0;
        int curr = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            curr = curr + nums[right];
            // We count the length of array <= k by the difference between l and r points,
            // and with "max" we store only the longer array
            while (curr > k) {
                curr = curr - nums[left];
                left++;
            }
            sum = Math.max(sum, right - left + 1);
        }
        return sum;
    }

    // Example 2: You are given a binary substring s (a string containing only "0" and "1").
    // An operation involves flipping a "0" into a "1". What is the length of the longest substring
    // containing only "1" after performing at most one operation?
    // For example, given s = "1101100111", the answer is 5. If you perform the operation at index 2,
    // the string becomes 1111100111.
    // Time: O(n)
    // Space: O(1)
    private static int findLengthTwo(String s) {
        int left = 0;
        int sum = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '0') {
                sum++;
            }
            // Check on "0", not more than one "0", if sum more than 1, we set to down to 1
            // C 2х сторон просто сужаем наше окно, двигаем наше окно с лева на право согласно нашим условиям
            // Если наш правый указатель уперся в ограничения, мы двигаем левый укатель к 1му "0" где пропустили и посчитали
            // его как "1" согласно нашим условиям, чтобы начать считать следющее окно
            while (sum > 1) {
                // Find our first "0", find our first constraint to pass it and let to right go further to next window to end
                if (s.charAt(left) == '0') {
                    sum--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    // Number of subarrays
    // Example 3: 713. Subarray Product Less Than K.
    // Given an array of positive integers nums and an integer k, return the number of contiguous subarrays where
    // the product of all the elements in the subarray is strictly less than k.
    // For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8.
    // The subarrays with products less than k are:
    // [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
    // Key idea: Whenever you see a problem asking for the number of subarrays, think of this: at each index,
    // how many valid subarrays end at this index? Let's split the 8 subarrays by their ending indices:
    // Time: O(n)
    // Space: O(1)
    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;

        for (int right = 0; right < nums.length; right++) {
            curr = curr * nums[right];
            while (left <= right && curr >= k) {
                curr = curr / nums[left];
                left++;
            }
            ans = ans + right - left + 1;
        }
        return ans;
    }

    // As we mentioned before, we can build a window of length k and then slide it along the array.
    // Add and remove one element at a time to make sure the window stays size k.
    // If we are adding the value at i, then we need to remove the value at i - k.
    // Time: O(n)
    // Space: O(1)
    private static int findTheBestSubarray(int[] nums, int k) {
        int curr = 0;
        for (int i = 0; i < k; i++) {
             curr += nums[i];
        }

        int ans = curr;
        for (int i = k; i < nums.length; i++) {
            curr += nums[i] - nums[i - k];
            ans = Math.max(ans, curr);
        }
        return ans;
    }

}
