package com.tasks.LeetCode.Arrays101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyFindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1}; // 5, 6
        int[] nums1 = {1, 1}; // 2

        System.out.println(findDisappearedNumbersApproach2(nums));
        System.out.println(findDisappearedNumbersApproach2(nums1));
    }

    // Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
    // the range [1, n] that do not appear in nums.

    // Example 1:
    // Input: nums = [4,3,2,7,8,2,3,1]
    // Output: [5,6]

    // Example 2:
    // Input: nums = [1,1]
    // Output: [2]

    // Constraints:
    // n == nums.length - ЭЛЕМЕНТ МАССИВА РАВЕН ДЛИНЕ МАССИВА
    // 1 <= n <= 10^5 - 1 МЕНЬШЕ ИЛИ РАВЕН ЭЛЕМЕНТУ ИЛИ 10 В 5Й СТЕПЕНИ
    // 1 <= nums[i] <= n - 1 МЕНЬШЕ ИЛИ РАВЕН ИНДЕКСУ МАССИИВА
    // - ТО ЕСТЬ ЭЛЕМЕНТ МАССИВА НЕ МОЖЕТ БЫТЬ БОЛЬШЕ ДЛИННЫ МАССИВА

    // Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not
    // count as extra space.

    // Solution
    // Approach 1: Using Hash Map
    // Intuition
    // The intuition behind using a hash map is pretty clear in this case. We are given that the array would be of
    // size N and it should contain numbers from 1 to N. However, some of the numbers are missing. All we have to do
    // is keep track of which numbers we encounter in the array and then iterate from 1⋯N1 \cdots N1⋯N and check
    // which numbers did not appear in the hash table. Those will be our missing numbers. Let's look at a formal
    // algorithm based on this idea and then an animation explaining the same with the help of a simple example.
    //
    // Algorithm
    // Initialize a hash map, hash to keep track of the numbers that we encounter in the array. Note that we can use a
    // set data structure as well in this case since we are not concerned about the frequency counts of elements.
    //
    //
    // Note that for the purposes of illustration, we have use a hash map of size 14 and have ordered the keys of the
    //  hash map from 0 to 14. Also, we will be using a simple hash function that directly maps the array entries to
    //  their corresponding keys in the hash map. Usually, the mapping is not this simple and is dependent upon the
    //  hash function being used in the implementation of the hash map.
    //
    // Next, iterate over the given array one element at a time and for each element, insert an entry in the hash map.
    //  Even if an entry were to exist before in the hash map, it will simply be over-written. For the above example,
    //  let's look at the final state of the hash map once we process the last element of the array.
    //
    //
    // Now that we know the unique set of elements from the array, we can simply find out the missing elements from
    //  the range 1⋯N1 \cdots N1⋯N.
    //
    // Iterate over all the numbers from 1⋯N1 \cdots N1⋯N and for each number, check if there's an entry in the hash
    // map. If there is no entry, add that missing number to a result array that we will return from the function
    // eventually.
    //
    // Current
    // Complexity Analysis
    // Time Complexity : O(N)
    // Space Complexity : O(N)

    private static List<Integer> findDisappearedNumbersApproach1(int[] nums) {

        // Hash table for keeping track of the numbers in the array
        // Note that we can also use a set here since we are not
        // really concerned with the frequency of numbers.
        HashMap<Integer, Boolean> map = new HashMap<>();

        // Add each of the numbers to the hash table
        for (final int num : nums) {
            map.put(num, true);
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<>();

        // Iterate over the numbers from 1 to N and add all those
        // that don't appear in the hash table.
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }

    // The solution works because 1 ≤ a[i] ≤ n (n = size of array)
    // As we walk through all elements in the array, we can use the current element as an index and flag its value (in
    // place). All numbers are > 0, so we can use a negative number.
    // In the end, the indexes of all positive numbers in the array are the missing values.
    //
    // The input: [4, 3, 2, 7, 8, 2, 3, 1]
    // Becomes: [-4, -3, -2, -7, 8, 2, -3, -1]
    //`
    // Starting from 1, the missing values are 5 and 6.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i : nums) {
            int index = Math.abs(i);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // Approach 2: O(1) Space InPlace Modification Solution
    // Intuition
    // We definitely need to keep track of all the unique numbers that appear in the array. However, we don't want to
    // use any extra space for it. This solution that we will look at in just a moment springs from the fact that

    // All the elements are in the range [1, N]

    // Since we are given this information, we can make use of the input array itself to somehow mark visited numbers
    // and then find our missing numbers. Now, we don't want to change the actual data in the array but who's
    // stopping us from changing the magnitude of numbers in the array? That is the basic idea behind this algorithm.

    // We will be negating the numbers seen in the array and use the sign of each of the numbers for finding our
    // missing numbers. We will be treating numbers in the array as indices and mark corresponding locations in the
    // array as negative.

    // Algorithm
    // Iterate over the input array one element at a time.
    // For each element nums[i], mark the element at the corresponding location negative if it's not already marked so
    //  i.e. nums[  nums[i]  −1  ]×−1nums[\; nums[i] \;- 1\;] \times -1nums[nums[i]−1]×−1 .
    // Now, loop over numbers from 1⋯N1 \cdots N1⋯N and for each number check if nums[j] is negative. If it is
    //  negative, that means we've seen this number somewhere in the array.
    // Add all the numbers to the resultant array which don't have their corresponding locations marked as negative in
    // the original array. Current

    // Complexity Analysis
    // Time Complexity : O(N)
    // Space Complexity : O(1) since we are reusing the input array itself as a hash table and the space
    // occupied by the output array doesn't count toward the space complexity of the algorithm.

    private static List<Integer> findDisappearedNumbersApproach2(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            // Как мы можем узнать где должна быть цифра? Если было бы все по порядку
            // [4, 3, 2, 7, 8, 2, 3, 1]
            // 1) 4 - 1 = индекс где эта цифра должна стоять, если бы массив был отсортирован = она существует в
            // нашем массиве
            // 2) 7 * -1 = -7, мы помечаем цифру отрицательной, тем самым мы помечаем что наша 4 существует в порядке
            // Мы выичеслям номер индекса через вычитание 1 от его элемента, потому что индексы от 0, а элементы от 1
            // 7 элемент - где ее адрес? 7 - 1 = ее адрес
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }
        return result;
    }

    private static List<Integer> test(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // let's create another array with same length
        // by default all index will contain zero
        // default value for int variable
        int[] register = new int[nums.length + 1];

        // now let's iterate over given array to
        // mark all present numbers in our register
        // array

        for (int i : nums) {
            register[i] = 1;
        }

        for (int i = 1; i < register.length; i++) {
            if (register[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

    private static List<Integer> findDisappearedNumbersBruteForceSolution(int[] nums) {
        List<Integer> result = new ArrayList<>();

        Set<Integer> set = new HashSet<>();

        for (final int num : nums) {
            set.add(num);
        }

        for (int i = 1; i < nums.length + 1; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}

