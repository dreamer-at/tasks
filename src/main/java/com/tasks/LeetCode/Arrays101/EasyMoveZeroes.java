package com.tasks.LeetCode.Arrays101;

import java.util.Arrays;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyMoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] nums1 = {0}; // 0
        int[] nums2 = {1}; // 1
        int[] nums3 = {1, 0}; // [1,0]
        int[] nums4 = {0, 1}; // [1,0]
        int[] nums5 = {2, 1}; // [2,2]
        int[] nums6 = {1, 0, 0}; // [1,0,0]

        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums)));
        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums1)));
        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums2)));
        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums3)));
        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums4)));
        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums5)));
        System.out.println(Arrays.toString(moveZeroesSwap1ms(nums6)));
    }

    // Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the
    // non-zero elements.
    // Note that you must do this in-place without making a copy of the array.

    // Example 1:
    // Input: nums = [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    // Example 2:
    // Input: nums = [0]
    // Output: [0]

    // Approach #2 (Space Optimal, Operation Sub-Optimal) [Accepted]
    // This approach works the same way as above, i.e. , first fulfills one requirement and then another. The catch?
    // It does it in a clever way. The above problem can also be stated in alternate way, " Bring all the non 0
    // elements to the front of array keeping their relative order same".

    // This is a 2 pointer approach. The fast pointer which is denoted by variable "cur" does the job of processing
    // new elements. If the newly found element is not a 0, we record it just after the last found non-0 element. The
    // position of last found non-0 element is denoted by the slow pointer "lastNonZeroFoundAt" variable. As we keep
    // finding new non-0 elements, we just overwrite them at the "lastNonZeroFoundAt + 1" 'th index. This overwrite
    // will not result in any loss of data because we already processed what was there(if it were non-0,it already is
    // now written at it's corresponding index,or if it were 0 it will be handled later in time).

    // After the "cur" index reaches the end of array, we now know that all the non-0 elements have been moved to
    // beginning of array in their original order. Now comes the time to fulfil other requirement, "Move all 0's to
    // the end". We now simply need to fill all the indexes after the "lastNonZeroFoundAt" index with 0.

    // Complexity Analysis
    // Space Complexity : O(1). Only constant space is used.
    // Time Complexity: O(n). However, the total number of operations are still sub-optimal. The total
    // operations (array writes) that code does is nnn (Total number of elements).

    private static int[] moveZeroesInPlaceApproach2(int[] nums) {
        int lastNonZeroFoundAt = 0;

        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
        return  nums;
    }

    private static int[] moveZeroesSwap1ms(int[] nums) {
        int j = 0;
        // Two pointer solution, pointer First is "i: will iterate all array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // To swap elements need to use temporary variable "temp", temp gets value from last swapped element
                // Pointer Second is "j" will store index for only not "0" numbers
                // 1) To swap element in temp we put 2d pointer value int temp = nums[j];
                // 2) nums[j] 2d pointer is pointer where we put not 0 numbers = nums[i] is an element not a 0
                // 3) nums[i] is index from where we get not 0 number,
                // we must put 0 to swap = temp is value from previous position,
                // from index because j is index that we want to replace on not 0 number
                // is always will be 0
                // temp - this value we changed, here we track only indices with value 0
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

    private static int[] moveZeroesSwap1msShort(int[] nums) {
        for (int i = 0, s = 0; i < nums.length; i++) {
            if (nums[i] != 0 && s++ < i) {
                nums[s - 1] = nums[i];
                nums[i] = 0;
            }
        }
        return nums;
    }

    private static int[] moveZeroesWithSpace(int[] nums) {
        int j = 0;
        int[] res = new int[nums.length];
        for (final int num : nums) {
            if (num != 0) {
                res[j] = num;
                j++;
            }
        }
        return res;
    }

}
