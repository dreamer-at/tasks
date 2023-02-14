package com.tasks.LeetCode.Arrays101;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasySortArrayByParity {

    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4};// [3,1,2,4]
        int[] nums1 = {0};// [0]
        int[] nums2 = {1};// [1]
        int[] nums3 = {0, 2};// [0,2]
        int[] nums4 = {0, 1, 2}; // [0,2,1]
        int[] nums5 = {1, 3, 0}; // [0,1,3]

        System.out.println(Arrays.toString(sortArrayByParityApproach3InPlace(nums)));
        System.out.println(Arrays.toString(sortArrayByParityApproach3InPlace(nums1)));
        System.out.println(Arrays.toString(sortArrayByParityApproach3InPlace(nums2)));
        System.out.println(Arrays.toString(sortArrayByParityApproach3InPlace(nums3)));
        System.out.println(Arrays.toString(sortArrayByParityApproach3InPlace(nums4)));
        System.out.println(Arrays.toString(sortArrayByParityApproach3InPlace(nums5)));
    }

    // Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd
    // integers.
    // Return any array that satisfies this condition.
    // Example 1:
    // Input: nums = [3,1,2,4]
    // Output: [2,4,3,1]
    // Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
    // Example 2:
    // Input: nums = [0]
    // Output: [0]

    private static int[] sortArrayByParityInPlaceBest(int[] nums) {

        if (nums.length == 1) {
            return nums;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                j++;
            }
        }
        return nums;
    }

    // Approach 1: Sort
    // Intuition and Algorithm
    // Use a custom comparator when sorting, to sort by parity.

    // Complexity Analysis
    // Time Complexity: O(NlogN), where N is the length of A.
    // Space Complexity: O(N) for the sort, depending on the built-in implementation of sort.

    private static int[] sortArrayByParityApproach1Stream(int[] nums) {
        return Arrays.stream(nums)
                     .boxed()
                     .sorted(Comparator.comparingInt(a -> a % 2))
                     .mapToInt(i -> i).toArray();
    }

    private static int[] sortArrayByParityApproach1(int[] nums) {
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }

        Arrays.sort(temp, Comparator.comparingInt(a -> a % 2));

        for (int j = 0; j < nums.length; j++) {
            nums[j] = temp[j];
        }

        return nums;
    }

    // Approach 2: Two Pass
    // Intuition and Algorithm
    // Write all the even elements first, then write all the odd elements.

    // Complexity Analysis
    // Time Complexity: O(N), where N is the length of nums.
    // Space Complexity: O(N), the space used by the answer.

    private static int[] sortByParityApproach2TwoLoops(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;

        for (final int even : nums) {
            if (even % 2 == 0) {
                res[j++] = even;
            }
        }

        for (final int odd : nums) {
            if (odd % 2 == 1) {
                res[j++] = odd;
            }
        }

        return res;
    }

    // Approach 3: In-Place
    // Intuition
    // If we want to do the sort in-place, we can use quicksort, a standard textbook algorithm.

    // Algorithm
    // We'll maintain two pointers i and j. The loop invariant is everything below i has parity 0 (ie. A[k] % 2 == 0
    // when k < i), and everything above j has parity 1.
    // Then, there are 4 cases for (A[i] % 2, A[j] % 2):
    // If it is (0, 1), then everything is correct: i++ and j--.
    // If it is (1, 0), we swap them so they are correct, then continue.
    // If it is (0, 0), only the i place is correct, so we i++ and continue.
    // If it is (1, 1), only the j place is correct, so we j-- and continue.
    // Throughout all 4 cases, the loop invariant is maintained, and j-i is getting smaller. So eventually we will be
    // done with the array sorted as desired.

    // Complexity Analysis
    // Time Complexity: O(N), where N is the length of A. Each step of the while loop makes j-i decrease by
    // at least one. (Note that while quicksort is (NlogN) normally, this is O(N)
    // because we only need one pass to sort the elements.)
    // Space Complexity: O(1) in additional space complexity.

    private static int[] sortArrayByParityApproach3InPlace(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 > nums[j] % 2) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            if (nums[i] % 2 == 0)
                i++;
            if (nums[j] % 2 == 1)
                j--;
        }
        return nums;
    }
}
