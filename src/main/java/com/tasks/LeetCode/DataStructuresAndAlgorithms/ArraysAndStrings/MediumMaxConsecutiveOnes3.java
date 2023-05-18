package com.tasks.LeetCode.DataStructuresAndAlgorithms.ArraysAndStrings;

public class MediumMaxConsecutiveOnes3 {


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}; // 6
        int k = 2;

        int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}; // 10
        int k1 = 3;

        System.out.println(longestOnesOfficial(nums, k));
        System.out.println();
       // System.out.println(longestOnesOfficial(nums1, k1));
    }

    private static int MaxConsecutiveOnes3(int[] nums, int k) {
        int l = 0;
        int sum = 0;
        int res = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                sum++;
            }

            while (sum > k) {
                if (nums[l] == 0) {
                    sum--;
                }
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    // Note: As suggested in the discussion forum. We can solve this problem a little efficiently.
    // Since we have to find the MAXIMUM window, we never reduce the size of the window.
    // We either increase the size of the window or remain same but never reduce the size.
    private static int longestOnesOfficial(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            // If we included a zero in the window we reduce the value of k.
            // Since k is the maximum zeros allowed in a window.
            if (nums[right] == 0) {
                k--;
            }
            // A negative k denotes we have consumed all allowed flips and window has
            // more than allowed zeros, thus increment left pointer by 1 to keep the window size same.
             if (k < 0) {
                // If the left element to be thrown out is zero we increase k.
                k = k + 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }
}