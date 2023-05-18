package com.tasks.LeetCode.DataStructuresAndAlgorithms.ArraysAndStrings;

public class EasyIsSubsequence {

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";
        String s1 = "axc";
        String t1 = "ahbgdc";

        System.out.println(isSubsequence(s, t));
        System.out.println(isSubsequence(s1, t1));
    }

    private static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}
