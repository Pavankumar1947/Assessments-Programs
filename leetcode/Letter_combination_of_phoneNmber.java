package com.eclothing.clothing.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = "2"
Output: ["a","b","c"] */

public class Letter_combination_of_phoneNmber {

    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits,0,new StringBuilder(),result);
        return result;
    }

    private static void backtrack(String digits, int i, StringBuilder current, List<String> result) {
        if(i == digits.length()){
            result.add(current.toString());
            return;
        }
        String letters = KEYPAD[digits.charAt(i) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);          // choose
            backtrack(digits, i + 1, current, result); // explore
            current.deleteCharAt(current.length() - 1);   // un-choose
        }
    }

}
