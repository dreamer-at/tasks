package com.tasks.LeetCode.DataStructuresAndAlgorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyTwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] nums1 = {3, 2, 4}; // 1, 2
        int target1 = 6;
        int[] nums2 = {3, 3};

        System.out.println(Arrays.toString(twoSumO(nums, target)));
        System.out.println(Arrays.toString(twoSumO(nums1, target1)));
        System.out.println(Arrays.toString(twoSumO(nums2, target1)));
    }

    // Time: O^2
    // Space: O(1)
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Time: O(n)
    // Space: O(n)
    private static int[] twoSumS(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i]; // map.get(sum) != i - it's check on duplicate of itself number
            if (map.containsKey(sum) && map.get(sum) != i) {
                return new int[]{i, map.get(sum)};
            }
        }
        // In case there is no solution, we'll just return true
        return null;
    }

    // Approach 3: One-pass Hash Table
    private static int[] twoSumO(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i};
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return true
        return null;
    }


}