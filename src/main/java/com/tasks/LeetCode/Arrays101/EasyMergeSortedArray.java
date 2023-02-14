package com.tasks.LeetCode.Arrays101;

import java.util.Arrays;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyMergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int n = 3;
        int[] nums2 = {2, 5, 6};
        int m = 3;

        System.out.println(Arrays.toString(mergeApproach3ThreePointers(nums1, n, nums2, m)));
    }

    // You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    // representing the number of elements in nums1 and nums2 respectively.
    // Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    // The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To
    // accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be
    // merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    // Example 1:
    // Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    // Output: [1,2,2,3,5,6]
    // Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
    // The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

    // Approach 1: Merge and sort
    // A naive approach would be to simply write the values from nums2 into the end of nums1, and then sort nums1.
    // Remember that we do not need to return a value, as we should modify nums1 in-place.
    // While straightforward to code, this approach has a high time complexity as we're not taking advantage of the
    // existing sorting.

    // Time complexity: O((n + m)log(n + m)).
    // The cost of sorting a list of length x using a built-in sorting algorithm is O(xlogx).
    // Because in this case we're sorting a list of length m+n, we get a total time complexity of O((n+m)log(n+m)).
    // Space complexity: O(n), but it can vary.
    // Most programming languages have a built-in sorting algorithm that uses O(n) space.
    private static int[] mergeApproach1MergeAndSort(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) { // O(m + n) time
            nums1[i + m] = nums2[i]; // Copy array to end of nums1 all from nums2
        }
        Arrays.sort(nums1); // Sort array to non-decreasing order - O(log n) time
        return nums1;
    }

    // Approach 2: Three Pointers (Start From the Beginning)
    // Intuition
    // Because each array is already sorted, we can achieve an O(n+m) time complexity with the help of the
    // two-pointer technique.
    // Algorithm
    // The simplest implementation would be to make a copy of the values in nums1, called nums1Copy,
    // and then use two read pointers and one write pointer to read values from nums1Copy and nums2 and write them
    // into nums1.
    // 1 - Initialize nums1Copy to be a new array containing the first m values of nums1.
    // 2 - Initialize read pointer p1 to the beginning of nums1Copy.
    // 3 - Initialize read pointer p2 to the beginning of nums2.
    // 4 - Initialize write pointer p to the beginning of nums1.
    // While p is still within nums1:
    //         - If nums1Copy[p1] exists and is less than or equal to nums2[p2]:
    //             - Write nums1Copy[p1] into nums1[p], and increment p1 by 1.
    //         - Else
    //             - Write nums2[p2] into nums1[p], and increment p2 by 1.
    //         - Increment p by 1.

    // Complexity Analysis
    // Time complexity: O(n+m).
    // We are performing n + 2 * m reads and n + 2. Because constants are ignored in Big
    // O notation, this gives us a time complexity of O(n+m).
    // Space complexity: O(m).
    // We are allocating an additional array of length m.
    private static int[] mergeApproach2ThreePointers(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of the first m elements of nums1.
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for numCopy1 and nums2 respectively.
        int p1 = 0;
        int p2 = 0;

        // Compare elements from nums1Copy and nums2 and write the smallest to nums1
        for (int p = 0; p < m + n; p++) {
            // We also need to ensure that p1 and p2 aren't over the boundaries
            // of their respective arrays.
            if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
                nums1[p] = nums1Copy[p1++];
            } else {
                nums1[p] = nums2[p2++];
            }
        }
        return nums1;
    }

    // Approach 3: Three Pointers (Start From the End)
    // Intuition
    // Interview Tip: This is a medium-level solution to an easy-level problem.
    // Many of LeetCode's easy-level problems have more difficult solutions, and good candidates are expected to find them.
    // So, what if instead we start to overwrite nums1 from the end, where there is no information yet?
    // The algorithm is similar to before, except this time we set p1 to point at index m - 1 of nums1,
    // p2 to point at index n - 1 of nums2, and p to point at index m + n - 1 of nums1.
    // This way, it is guaranteed that once we start overwriting the first m values in nums1,
    // we will have already written each into its new position. In this way, we can eliminate the additional space.

    // Interview Tip: Whenever you're trying to solve an array problem in-place,
    // always consider the possibility of iterating backwards instead of forwards through the array.
    // It can completely change the problem, and make it a lot easier.

    // Proof (optional)
    // You might be a bit skeptical of this claim. Does it really work in every case? Is it safe to be making such a
    // bold claim?
    // - This way, it is guaranteed that once we start overwriting the first m values in nums1,
    // we will have already written each into its new position. In this way, we can eliminate the additional space.
    // Great question! So, why does this work? To prove it,
    // we need to ensure that p never overwrites a value in nums1 that p1 hasn't yet read from nums1.

    // Words of Advice: Terrified of proofs? Many software engineers are. Good proofs are simply a series of logical assertions,
    // each building on the next. In this way, we can go from "obvious" statements, all the way to the one we want to prove.
    // I recommend reading each statement one-by-one, ensuring that you understand each before moving onto the next.

    // 1. We know that upon initialization, p is n steps ahead of p1 (in other words, p1 + n = p).
    // 2. We also know that during each of the p iterations this algorithm performs, p is always decremented by 1,
    // and either p1 or p2 is decremented by 1.
    // 3. We can deduce that when p1 decremented, the gap between p and p1 stays the same, so there can't be an "overtake" in that case.
    // 4. We can also deduce that when p2 is decremented though, the gap between p and p1 shrinks by 1 as p moves, but not p1.
    // 5. And from that, we can deduce that the maximum number of times that p2 can be decremented is n. In other words,
    // the gap between p and p1 can shrink by 1, at most n times.

    // Complexity Analysis
    // Time complexity: O(n+m).
    // Same as Approach 2.
    // Space complexity: O(1).
    // Unlike Approach 2, we're not using an extra array.
    private static int[] mergeApproach3ThreePointers(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backwards through the array, each time writing
        // the smallest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break; // In case when nums2 = [], n = 0 OR when p2-- will end
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
        return nums1;
    }

    // Time: O(m + n)
    // Space: O(1)
    private void merge0ms(int[] nums1, int m, int[] nums2, int n) {
        int endIndex = m + n - 1;
        int endNum1 = m - 1;
        int endNum2 = n - 1;

        while (endNum1 >= 0 && endNum2 >= 0) {
            if (nums1[endNum1] > nums2[endNum2]) {
                nums1[endIndex] = nums1[endNum1];
                endNum1--;
            } else {
                nums1[endIndex] = nums2[endNum2];
                endNum2--;
            }
            endIndex--;
        }

        while (endNum1 >= 0) {
            nums1[endIndex--] = nums1[endNum1--];

        }

        while (endNum2 >= 0) {
            nums1[endIndex--] = nums2[endNum2--];
        }
    }

    // Time: O(n)
    // Space: O(n) or log(n)
    private void merge2Ms(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

}
