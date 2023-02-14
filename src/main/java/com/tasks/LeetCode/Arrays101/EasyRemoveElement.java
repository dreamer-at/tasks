package com.tasks.LeetCode.Arrays101;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyRemoveElement {

    // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    // The relative order of the elements may be changed.
    // Since it is impossible to change the length of the array in some languages,
    // you must instead have the result be placed in the first part of the array nums.
    // More formally, if there are k elements after removing the duplicates,
    // then the first k elements of nums should hold the final result.
    // It does not matter what you leave beyond the first k elements.

    // Return k after placing the final result in the first k slots of nums.

    // Do not allocate extra space for another array. You must do this by modifying the input array in-place with O
    // (1) extra memory. In-place algorithm has O(1) extra memory.

    // Input: nums = [3,2,2,3], val = 3
    // Output: 2, nums = [2,2,_,_]
    // Explanation: Your function should return k = 2, with the first two elements of nums being 2.
    // It does not matter what you leave beyond the returned k (hence they are underscores).

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val1 = 2;

        int[] numsRare = {1, 2, 3, 5, 4};
        int valRare = 4;

        System.out.println(removeElement(nums, val));
    }

    // Approach 1: Two Pointers

    // Intuition
    // Since this question is asking us to remove all elements of the given value in-place,
    // we have to handle it with O(1)O(1) extra space.

    // Algorithm
    // When nums[j]nums[j] equals to the given value, skip this element by incrementing [j]. As long as nums[j] != val,
    // we copy nums[j] to nums[i] and increment both indexes at the same time.
    // Repeat the process until [j] reaches the end of the array and the new length is [i].

    // This solution is very similar to the solution to Remove Duplicates from Sorted Array.

    // Complexity analysis
    // Time complexity : O(n). Assume the array has a total of n elements, both i and j traverse at most 2n steps.
    // Space complexity : O(1).

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                // That row nums[i] = nums[j] only to pass test case on leetcode,
                // they check your answer array on elements, for example [2, 2] should be in 1t case
                i++;
            }
        }
        return i; // Here we return not remainder of the elements, we return all not matches between nums[j] != and val
    }

    // Approach 2: Two Pointers - when elements to remove are rare

    // Intuition
    // Now consider cases where the array contains few elements to remove.
    // For example, nums = [1,2,3,5,4], val = 4.
    // The previous algorithm will do unnecessary copy operation of the first four elements.
    // Another example is nums = [4,1,2,3,5], val = 4.
    // It seems unnecessary to move elements [1,2,3,5] one step left as the problem description mentions
    // that the order of elements could be changed.

    // Algorithm
    // When we encounter nums[i]=val, we can swap the current element out with the last element and dispose the last one.
    // This essentially reduces the array's size by 1.
    // Note that the last element that was swapped in could be the value you want to remove itself. But don't worry,
    // in the next iteration we will still check this element.

    // Complexity analysis
    // Time complexity : O(n). Both i and n traverse at most n steps.
    // In this approach, the number of assignment operations is equal to the number of elements to remove.
    // So it is more efficient if elements to remove are rare.
    // Space complexity : O(1).

    private static int removeElementRare(int[] nums, int val) {
        int i = 0; // Two pointers function where i is start of array and n is the and of array
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--; // remainder of our not matching numbers, we replace only occurrence element (nums.length)
            } else {
                i++;
            }
        }
        return n;
    }
}
