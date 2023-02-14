package com.tasks.LeetCode.Arrays101;


import java.util.Arrays;

/**
 * TODO: Change class description
 *
 * @author askhat.talasbayev (atalasba)
 * @since 0.18.0
 */
public class EasyHeadChecker {

    public static void main(String[] args) {
        int[] heights = {1, 1, 4, 2, 1, 3};
        int[] heights1 = {5, 1, 2, 3, 4};
        int[] heights2 = {1, 2, 3, 4, 5};

        System.out.println(heightCheckerCountSortBest(heights));

        System.out.println(heightCheckerCountSortBest(heights1));
        System.out.println(heightCheckerCountSortBest(heights2));

        System.out.println(Arrays.toString(countSort(heights)));


        test();
    }

    // A school is trying to take an annual photo of all the students.
    // The students are asked to stand in a single file line in non-decreasing order by height.
    // Let this ordering be represented by the integer array expected where expected[i] is the expected height of the
    // ith student in line.

    // Example 1:
    // Input: heights = [1,1,4,2,1,3]
    // Output: 3
    // Explanation:
    // heights:  [1,1,4,2,1,3]
    // expected: [1,1,1,2,3,4]
    // Indices 2, 4, and 5 do not match.

    // Example 2:
    // Input: heights = [5,1,2,3,4]
    // Output: 5
    // Explanation:
    // heights:  [5,1,2,3,4]
    // expected: [1,2,3,4,5]
    // All indices do not match.

    // Example 3:
    // Input: heights = [1,2,3,4,5]
    // Output: 0
    // Explanation:
    // heights:  [1,2,3,4,5]
    // expected: [1,2,3,4,5]
    // All indices match.

    // Hint: Build the correct order of heights by sorting another array, then compare the two arrays.

    // Insertion sort will be better solution because we dont need to iterate 2 loops n^2 times,
    // With insertion sort we need to iterate 1 time as a loop elements

    private static int heightCheckerInsertionSort(int[] heights) {
        int n = heights.length;
        int count = 0;
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = heights[i];
        }

        // insertionSortSimpleVersion(sorted);

        // Insertion sort Java SDK realisation
        // ai - support element, sort the entire array in front of ai support element and shift the array to the right
        for (int i, k = 0; ++k < n; ) {
            int ai = sorted[i = k];
            // if support element less than previous element
            if (ai < sorted[i - 1]) {
                // while loop - if (i - 1) >= 0 && ai < sorted[i] - reduce i to swap all elements where ai < left
                // element
                while (--i >= 0 && ai < sorted[i]) {
                    // put bigger element > ai instead of ai, while i >=0 if elements fro right side is reduce
                    sorted[i + 1] = sorted[i];
                }
                // put element less ai to left side, swap
                sorted[i + 1] = ai;
            }
        }

        for (int i = 0; i < n; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    // Without SORT?
    // Count sort, iterate all loop and count all numbers, than write to array that numbers
    private static int heightCheckerCountSortBest(int[] heights) {
        int[] heightToFreq = new int[6];

        for (int h : heights) {
            ++heightToFreq[h];
        }

        int result = 0;
        int curHeight = 0;

        for (final int height : heights) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }
            if (curHeight != height) {
                result++;
            }
            heightToFreq[curHeight]--;
        }
        return result;
    }

    private static int[] countSort(int[] arr) {
        final int MAX_VALUE = 101;

        int[] count = new int[MAX_VALUE];

        for (int i = 0; i < arr.length; i++) {
            // Increase count + 1 value on index when arr[i] number equal to count[i] index
            // count[arr[i] - is number of index] and count[arr[i] - is number of index] increase value ++  = +1
            // To count our numbers, WE sort with counting of elements to their indices numbers
            // for example arr [1, 1, 4, 2, 1, 3]
            // fill array       0  2  1  1  1  0
            // and our count   [0, 1, 2, 3, 4, 5]
            // print values [1, 1, 4, 2, 1, 3]
            count[arr[i]] = ++count[arr[i]];
        }

        int arrayIndex = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr[arrayIndex] = i;
                arrayIndex++;
            }
        }
        return arr;
    }

    public int heightCheckerCountSort(int[] heights) {
        int[] map = new int[101]; // heights go from 1 to 100
        for (int h : heights) {
            ++map[h];
        }

        int res = 0;
        int h_ptr = 1;

        for (int h : heights) {
            while (map[h_ptr] == 0) {
                ++h_ptr;
            }

            if (h_ptr != h) {
                ++res;
            }

            --map[h_ptr];
        }

        return res;
    }

    public static void insertionSortSimpleVersion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }

    private static int heightChecker8s(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < copy.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }

       /* private static void insertionSort(float[] a, int low, int high) {
            for (int i, k = low; ++k < high; ) {
                float ai = a[i = k];

                if (ai < a[i - 1]) {
                    while (--i >= low && ai < a[i]) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = ai;
                }
            }
        }*/

    private static int heightChecker(int[] heights) {
        int n = heights.length;
        int count = 0;
        int[] sorted = new int[n];
        System.arraycopy(heights, 0, sorted, 0, n);
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    private static int heightCheckerBubbleSort2(int[] heights) {
        int n = heights.length;
        int count = 0;
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = heights[i];
        }

        // Outer for loop need to iterate ever element
        bubbleSort(sorted);

        for (int i = 0; i < n; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    public static void bubbleSort(int[] array) {
        boolean unsorted = true;
        int temp;
        while (unsorted) {
            unsorted = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    unsorted = true;
                }
            }
        }
    }

    private static int heightCheckerBubbleSort1(int[] heights) {
        int n = heights.length;
        int count = 0;
        int[] sorted = new int[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = heights[i];
        }

        // Outer for loop need to iterate every element
        // The number of elements in the array is equal to the number of sorting, each time we sort based on the
        // number of elements,
        // this provides us with a sorted array, even if it is already sorted in 1 or 2 steps,
        // we will resell based on the number of elements in the array
        for (int i = 0; i < n - 1; i++) {
            // inner for loop compare two elements
            for (int j = 0; j < (n - i - 1); j++) {
                if (sorted[j + 1] < sorted[j]) {
                    int swap = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = swap;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }

    private static void mixedInsertionSort(long[] a, int low, int end, int high) {
        if (end == high) {

            /*
             * Invoke simple insertion sort on tiny array.
             */
            for (int i; ++low < end; ) {
                long ai = a[i = low];

                while (ai < a[--i]) {
                    a[i + 1] = a[i];
                }
                a[i + 1] = ai;
            }
        } else {

            /*
             * Start with pin insertion sort on small part.
             *
             * Pin insertion sort is extended simple insertion sort.
             * The main idea of this sort is to put elements larger
             * than an element called pin to the end of array (the
             * proper area for such elements). It avoids expensive
             * movements of these elements through the whole array.
             */
            long pin = a[end];

            for (int i, p = high; ++low < end; ) {
                long ai = a[i = low];

                if (ai < a[i - 1]) { // Small element

                    /*
                     * Insert small element into sorted part.
                     */
                    a[i] = a[--i];

                    while (ai < a[--i]) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = ai;

                } else if (p > i && ai > pin) { // Large element

                    /*
                     * Find element smaller than pin.
                     */
                    while (a[--p] > pin) ;

                    /*
                     * Swap it with large element.
                     */
                    if (p > i) {
                        ai = a[p];
                        a[p] = a[i];
                    }

                    /*
                     * Insert small element into sorted part.
                     */
                    while (ai < a[--i]) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = ai;
                }
            }

            /*
             * Continue with pair insertion sort on remain part.
             */
            for (int i; low < high; ++low) {
                long a1 = a[i = low], a2 = a[++low];

                /*
                 * Insert two elements per iteration: at first, insert the
                 * larger element and then insert the smaller element, but
                 * from the position where the larger element was inserted.
                 */
                if (a1 > a2) {

                    while (a1 < a[--i]) {
                        a[i + 2] = a[i];
                    }
                    a[++i + 1] = a1;

                    while (a2 < a[--i]) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = a2;

                } else if (a1 < a[i - 1]) {

                    while (a2 < a[--i]) {
                        a[i + 2] = a[i];
                    }
                    a[++i + 1] = a2;

                    while (a1 < a[--i]) {
                        a[i + 1] = a[i];
                    }
                    a[i + 1] = a1;
                }
            }
        }
    }

    private static void measureTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long elapsed = System.currentTimeMillis() - startTime;
        System.out.println("Затраченное время: " + elapsed + " ms");
    }

    private static void test() {
        int testLen = 101;

        int[] arr1 = new int[testLen];
        int[] arr2 = new int[testLen];

        System.out.println("---Сравнение быстрой сортировки и сортировки подсчетом---");

        for (int i = 0; i < testLen; i++) {
            arr2[i] = arr1[i] = (int) Math.round(Math.random() * 99);
        }

        System.out.println("Insertion Sort:");
        measureTime(() -> heightCheckerInsertionSort(arr1));

        System.out.println("Count sort:");
        measureTime(() -> heightCheckerCountSortBest(arr2));
    }
}
