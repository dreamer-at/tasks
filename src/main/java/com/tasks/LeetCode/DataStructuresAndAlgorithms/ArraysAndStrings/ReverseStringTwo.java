package com.tasks.LeetCode.DataStructuresAndAlgorithms.ArraysAndStrings;

public class ReverseStringTwo {

    public static void main(String[] args) {

        // Given a string s and an integer k,
        // reverse the first k characters for every 2k characters counting
        // from the start of the string.
        // If there are fewer than k characters left, reverse all of them.
        // If there are less than 2k but greater than or equal to k characters,
        // then reverse the first k characters and leave the other as original.

        String s = "abcdefg"; // bacdfeg
        int k = 2;

        String s1 = "abcd"; // bacd
        int k1 = 2;

        System.out.println(reverseStr(s, k));
        System.out.println(reverseStr(s1, k1));
    }

    private static String reverseStr(final String s, final int k) {
        return "";
    }


}
