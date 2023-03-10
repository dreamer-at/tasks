package com.tasks.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class EasyRomanToInteger {

    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    // Symbol       Value
    // I             1
    // V             5
    // X             10
    // L             50
    // C             100
    // D             500
    // M             1000
    // For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is
    // simply X + II. The number 27 is written as XXVII, which is XX + V + II.
    //
    // Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
    // IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
    // The same principle applies to the number nine, which is written as IX. There are six instances where
    // subtraction is used:
    //
    // I can be placed before V (5) and X (10) to make 4 and 9.
    // X can be placed before L (50) and C (100) to make 40 and 90.
    // C can be placed before D (500) and M (1000) to make 400 and 900.
    // Given a roman numeral, convert it to an integer.

    // Example 1:
    // Input: s = "III"
    // Output: 3
    // Explanation: III = 3.

    // Example 2:
    // Input: s = "LVIII"
    // Output: 58
    // Explanation: L = 50, V= 5, III = 3.

    // Example 3:
    // Input: s = "MCMXCIV"
    // Output: 1994
    // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

    // Constraints:
    // 1 <= s.length <= 15
    // s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    // It is guaranteed that s is a valid roman numeral in the range [1, 3999].

    public static void main(String[] args) {
        String s = "III";
        String s1 = "LVIII";
        String s2 = "MCMXCIV";

        System.out.println(romanToInt(s)); // 3
        System.out.println(romanToInt(s1)); // 58
        System.out.println(romanToInt(s2)); // 1994
    }

    // Approach 1: Left-to-Right Pass
    // Now, recall that each symbol adds its own value, except for when a smaller valued symbol is before a larger
    // valued symbol. In those cases, instead of adding both symbols to the total, we need to subtract the large from
    // the small, adding that instead.

    // Therefore, the simplest algorithm is to use a pointer to scan through the string, at each step deciding whether
    // to add the current symbol and go forward 1 place, or add the difference of the next 2 symbols and go forward 2
    // places. Here is this algorithm in pseudocode.

    // Complexity Analysis
    //
    //Let nnn be the length of the input string (the total number of symbols in it).
    //
    //Time complexity : O(1).
    //
    //As there is a finite set of roman numerals, the maximum number possible number can be 3999, which in roman
    // numerals is MMMCMXCIX. As such the time complexity is O(1)O(1)O(1).
    //
    //If roman numerals had an arbitrary number of symbols, then the time complexity would be proportional to the
    // length of the input, i.e. O(n)O(n)O(n). This is assuming that looking up the value of each symbol is O(1)O(1)O
    // (1).
    //
    //Space complexity : O(1).
    //
    //Because only a constant number of single-value variables are used, the space complexity is O(1)O(1)O(1).

    public int romanToIntTheFast(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }


    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    // Complexity Analysis
    // Time complexity : O(1).
    // Same as Approach 1.
    // Space complexity : O(1).
    // Same as Approach 1.
    private static int romanToInt(String s) {
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = values.get(lastSymbol);
        int total = lastValue;
        // If we start from the end, we can not count previous and next bigger
        for (int i = s.length() - 2; i >= 0; i--) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);

            if (currentValue < lastValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }


    public static int romanToIntOne(String s) {

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            } else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }
}
