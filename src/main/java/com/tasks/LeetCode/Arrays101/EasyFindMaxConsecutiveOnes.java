package com.tasks.LeetCode.Arrays101;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyFindMaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnesD(nums));
    }

    // Given a binary array nums, return the maximum number of consecutive 1's in the array.
    // Input: nums = [1,1,0,1,1,1]
    // Output: 3
    // Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of
    // consecutive 1s is 3.

    // Approach: One pass

    // Intuition
    // The intuition is pretty simple. We keep a count of the number of 1's encountered. And reset the count whenever
    // we encounter anything other than 1 (which is 0 for this problem). Thus, maintaining count of 1's between zeros
    // or rather maintaining counts of contiguous 1's. It's the same as keeping a track of the number of hours of
    // sleep you had, without waking up in between.

    // Complexity Analysis
    // Time Complexity: O(N), where N is the number of elements in the array.
    // Space Complexity: O(1). We do not use any extra space.

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment the count of 1's by one.
                count += 1;
            } else {
                // Find the maximum till now.
                maxCount = Math.max(maxCount, count);
                // Reset count of 1.
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }

    public static int findMaxConsecutiveOnesD(int[] nums) {
        int res = 0, max = 0;
        for (int i : nums) {
            if (i == 0) {
                res = 0;
            } else {
                res += 1;
                max = Math.max(max, res);
            }
        }
        return max;
    }
}
