package com.tasks.LeetCode;

public class EasyLongestCommonPrefix {

    // Write a function to find the longest common prefix string amongst an array of strings.
    // If there is no common prefix, return an empty string "".

    // Example 1:
    // Input: strs = ["flower","flow","flight"]
    // Output: "fl"

    // Example 2:
    // Input: strs = ["dog","racecar","car"]
    // Output: ""
    // Explanation: There is no common prefix among the input strings.

    // Constraints:
    // 1 <= strs.length <= 200
    // 0 <= strs[i].length <= 200
    // strs[i] consists of only lowercase English letters.

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog", "racecar", "car"};

        System.out.println(longestCommonPrefixFour(strs));
        System.out.println(longestCommonPrefixFour(strs1));
    }

    // Approach 4: Binary search
    public static String longestCommonPrefixFour(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) { // calculate min length in strs array
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int middle) {
        String str1 = strs[0].substring(0, middle);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        }
        return true;
    }

    // Approach 3: Divide and conquer
    public static String longestCommonPrefixThree(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefixThree(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefixThree(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefixThree(strs, l, mid);
            String lcpRight = longestCommonPrefixThree(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    // Approach 2: Vertical scanning
    // Algorithm
    // Imagine a very short string is the common prefix at the end of the array. The above approach will still do SSS
    // comparisons. One way to optimize this case is to do vertical scanning. We compare characters from top to
    // bottom on the same column (same character index of the strings) before moving on to the next column.

    // Complexity Analysis
    // Time complexity : O(S), where S is the sum of all characters in all strings. In the worst case there
    // will be n equal strings with length m and the algorithm performs S=m⋅n character
    // comparisons. Even though the worst case is still the same as Approach 1, in the best case there are at most
    // n⋅minLen comparisons where minLen is the length of the shortest string in the array.
    // Space complexity : O(1). We only used constant extra space.
    private static String longestCommonPrefixTwo(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // compare char by char first word with others and if sequence not equal, then immediately return
                // sequence,
                // because we found our the same prefix (sequence of the same chard)
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    // Approach 1: Horizontal scanning
    // Intuition
    // For a start we will describe a simple way of finding the longest prefix shared by a set of strings LCP(S1…Sn)
    // We will use the observation that: LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)

    // Algorithm
    // To employ this idea, the algorithm iterates through the strings [S1…Sn] finding at each iteration i
    // the longest common prefix of strings LCP(S1…Si) When LCP(S1…Si) is an empty string,
    // the algorithm ends. Otherwise after nnn iterations, the algorithm returns LCP(S1…Sn)

    // Complexity Analysis
    // Time complexity : O(S)O(S)O(S) , where S is the sum of all characters in all strings.
    // In the worst case all nnn strings are the same. The algorithm compares the string S1S1S1 with the other strings
    // [S2…Sn][S_2 \ldots S_n][S] There are SSS character comparisons, where SSS is the sum of all characters in the
    // input array.
    // Space complexity : O(1). We only used constant extra space.

    private static String longestCommonPrefixOne(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // strs[i].indexOf(prefix) - if prefix is too long, we cut 1 char from end and repeat operation,
                // to find occurrence between words, the main function is indexOf who's searching the first occurrence
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
