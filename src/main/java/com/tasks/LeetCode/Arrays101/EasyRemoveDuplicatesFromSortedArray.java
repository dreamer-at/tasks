package com.tasks.LeetCode.Arrays101;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyRemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int[] nums1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums1));
    }

    // Given an integer array nums sorted in non-decreasing order,
    // remove the duplicates in-place such that each unique element appears only once.
    // The relative order of the elements should be kept the same.

    // Since it is impossible to change the length of the array in some languages,
    // you must instead have the result be placed in the first part of the array nums. More formally,
    // if there are k elements after removing the duplicates, then the first k elements of nums should hold the final
    // result.
    // It does not matter what you leave beyond the first k elements.

    // Return k after placing the final result in the first k slots of nums.
    // Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1)
    // extra memory.

    // Example 1:
    // Input: nums = [1,1,2]
    // Output: 2, nums = [1,2,_]
    // Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    // It does not matter what you leave beyond the returned k (hence they are underscores).

    // Example 2:
    // Input: nums = [0,0,1,1,1,2,2,3,3,4]
    // Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    // Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4
    // respectively.
    // It does not matter what you leave beyond the returned k (hence they are underscores).

    // Intuition
    // To solve the problem, let's look at the condition carefully,
    // It is guaranteed that the given array is a sorted array.
    // Let k be the count of unique elements in our input array.
    // It doesn't matter what elements we place after the first k elements.
    // From the condition, we can have a few observations here,
    // Since the array we have is sorted, all duplicate values will be one after the other.
    // We need to update the first k elements in an array with unique values and return the value of k.
    // Using the following intuition, let's understand how to address this problem.
    // The problem states that we need to fill the first k elements of an array with unique values
    // For doing so, we modify the input array in-place so that we don't use extra space
    // In order to perform in-place operations, we use the Two indexes approach
    // The first index updates the value in our input array while reading the data from the second index
    // First Index is responsible for writing unique values in our input array, while Second Index will read the input
    // array and pass all the distinct elements to First Index.
    // We continue the above steps until the second index reaches the end of an array

    // Algorithm
    // By analyzing the above three key observations, we can derive the following algorithm,
    // Start both indexes (insertIndex, i) from 1.
    // insertIndex and i represents our First and second Index respectively.
    // Check if the previous element is different from the current element
    // The previous element is the element just before our i index i.e element present at arr[i-1]
    // If found different then perform arr[insertIndex] = arr[i] and increment insertIndex by 1
    // Increment i index by 1 till we reach end of the array
    // Note: After reaching the end of the array, our insertIndex variable will hold the count of unique elements in
    // our input array.

    // Complexity Analysis
    // Let N be the size of the input array.
    // Time Complexity: O(N), since we only have 2 pointers, and both the pointers will traverse the array at
    // most once.
    // Space Complexity: O(1), since we are not using any extra space.
    private static int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            // We skip to next index if we see a duplicate element
            if (nums[i - 1] != nums[i]) {
                // we will move forward and the elements of "not equal != will be count of duplicate elements"
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex] = nums[i]; // insertIndex - is index is the boundary of the end of duplicate numbers
                // insertIndex - will be store the last duplicate index and remainder of duplicate numbers
                insertIndex++;
            }
        }
        return insertIndex;
    }

    // Implementing this requires the use of the two-pointer technique. This is where we iterate over the Array in
    // two different places at the same time.
    // Read all the elements like we did before, to identify the duplicates. We call this our readPointer.
    // Keep track of the next position in the front to write the next unique element we've found. We call this our
    // writePointer.
    // Here's the algorithm in Java code

    public int removeDuplicatesBest(int[] nums) {

        // Check for edge cases.
        if (nums == null) {
            return 0;
        }

        // Use the two pointer technique to remove the duplicates in-place.
        // The first element shouldn't be touched; it's already in its correct place.
        int writePointer = 1;
        // Go through each element in the Array.
        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            // If the current element we're reading is *different* to the previous
            // element...
            if (nums[readPointer] != nums[readPointer - 1]) {
                // Copy it into the next position at the front, tracked by writePointer.
                nums[writePointer] = nums[readPointer];
                // And we need to now increment writePointer, because the next element
                // should be written one space over.
                writePointer++;
            }
        }

        // This turns out to be the correct length value.
        return writePointer;
    }

    public int removeDuplicatesStandard(int[] nums) {
        // The initial length is simply the capacity.
        int length = nums.length;

        // Assume the last element is always unique.
        // Then for each element, delete it iff it is
        // the same as the one after it. Use our deletion
        // algorithm for deleting from any index.
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] == nums[i + 1]) {
                // Delete the element at index i, using our standard
                // deletion algorithm we learned.
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                // Reduce the length by 1.
                length--;
            }
        }
        // Return the new length.
        return length;
    }

    private static int removeDuplicatesMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }
        return (int) map.values().stream().distinct().count();
    }

    private static int removeDuplicatesHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }

    public int[] copyWithRemovedDuplicates(int[] nums) {

        // Check for edge cases.
        if (nums == null || nums.length == 0) {
            return nums;
        }

        // Count how many unique elements are in the Array.
        int uniqueNumbers = 0;
        for (int i = 0; i < nums.length; i++) {
            // An element should be counted as unique if it's the first
            // element in the Array, or is different to the one before it.
            if (i == 0 || nums[i] != nums[i - 1]) {
                uniqueNumbers++;
            }
        }

        // Create a result Array.
        int[] result = new int[uniqueNumbers];

        // Write the unique elements into the result Array.
        int positionInResult = 0;
        for (int i = 0; i < nums.length; i++) {
            // Same condition as in the previous loop. Except this time, we can write
            // each unique number into the result Array instead of just counting them.
            if (i == 0 || nums[i] != nums[i - 1]) {
                result[positionInResult] = nums[i];
                positionInResult++;
            }
        }
        return result;
    }
}
