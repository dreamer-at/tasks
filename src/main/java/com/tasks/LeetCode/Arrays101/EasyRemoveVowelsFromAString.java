package com.tasks.LeetCode.Arrays101;

public class EasyRemoveVowelsFromAString {

    public static void main(String[] args) {

        String s = "leetcodeisacommunityforcoders";

        System.out.println(removeVowels(s));
    }

    // Given a string s, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

    // Example 1:
    // Input: s = "leetcodeisacommunityforcoders"
    // Output: "ltcdscmmntyfrcdrs"

    // Example 2:
    // Input: s = "aeiou"
    // Output: ""

    // Constraints:
    // 1 <= s.length <= 1000
    // s consists of only lowercase English letters.

    private static String removeVowels(String s) {
        // 'a', 'e', 'i', 'o', 'u'

        return s.replaceAll("[aeiou]", "");
    }
}
