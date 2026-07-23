package Prac;

import java.io.BufferedReader;
import java.io.InputStreamReader;


// IBM 23/7/2026
class Result {

    public static int solvePalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int replacements = 0;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                replacements++;
            }
            left++;
            right--;
        }

        return replacements;
    }
}

public class Palindrome {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int result = Result.solvePalindrome(s);

        System.out.println(result);

        br.close();
    }
}
