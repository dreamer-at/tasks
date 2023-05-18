package com.tasks.LeetCode.DataStructuresAndAlgorithms.ArraysAndStrings;

import java.util.Objects;

public class EasyReverseString {

    public static void main(String[] args) {
        char[] s = {'a','b','c',};
        char[] s1 = {'h','e','l','l','o',};
        char[] s2 = {'H','a','n','n','a','h',};
        char[] s3 = {'h','a','n','n','a','H',};
        System.out.println(reverseString(s));
        System.out.println(reverseString(s1));
        System.out.println(reverseString(s2));
    }

    private static char[] reverseString(char[] s) {
        int j  = s.length - 1;
        for (int i = 0; i < j; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            j--;
        }
        return s;
    }

    public void reverseStringOfficialSolution(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}
