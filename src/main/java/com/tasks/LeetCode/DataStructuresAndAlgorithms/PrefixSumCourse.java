package com.tasks.LeetCode.DataStructuresAndAlgorithms;

import java.util.Arrays;

public class PrefixSumCourse {

    public static void main(String[] args) {

        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {{0, 3}, {2, 5}, {2, 4}};
        int limit = 13;

        int[] nums1 = {10, 4, -8, 7};

        // System.out.println(Arrays.toString(answerQueries(nums, queries, limit)));
        System.out.println(waysToSplitArray(nums1));
        System.out.println(waysToSplitArrayBest(nums1));
    }

    // Time: O(n)
    // Space: O(1)
    private static int waysToSplitArrayBest(final int[] nums) {
        int res = 0;
        long leftSection = 0;
        long total = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            leftSection += nums[i];
            long rightSection = total - leftSection;
            if (leftSection >= rightSection) {
                res++;
            }
        }
        return res;
    }

    // Time: O(n)
    // Space: O(n)
    private static int waysToSplitArray(final int[] nums) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long leftSection = prefix[i];
            long rightSection = prefix[nums.length - 1] - prefix[i];
            if (leftSection >= rightSection) {
                ans++;
            }

        }
        return ans;
    }

    // Time: O(m + n)
    // Space: O(n)
    private static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i]; // sum of cur and next element
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1]; // matrix of queries x{array, first element}, y{array, second element}
            int curr = prefix[y] - prefix[x] + nums[x];
            ans[i] = curr < limit;
        }
        return ans;
    }


}
