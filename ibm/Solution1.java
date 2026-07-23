package Prac;

import java.io.*;
import java.util.*;


//IBM 23/7/2026
class Result1 {

    public static String decode(String encoded) {

        // Reverse the encoded string
        String reversed = new StringBuilder(encoded).reverse().toString();

        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < reversed.length()) {

            // Space character (ASCII 32)
            if (i + 1 < reversed.length()
                    && reversed.charAt(i) == '3'
                    && reversed.charAt(i + 1) == '2') {
                ans.append(' ');
                i += 2;
            }
            // Lowercase letters with ASCII 100-122
            else if (reversed.charAt(i) == '1') {

                int ascii = Integer.parseInt(reversed.substring(i, i + 3));
                ans.append((char) ascii);
                i += 3;
            }
            // Uppercase letters (65-90) and lowercase 97-99
            else {
                int ascii = Integer.parseInt(reversed.substring(i, i + 2));
                ans.append((char) ascii);
                i += 2;
            }
        }
        return ans.toString();
    }

}

public class Solution1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String encoded = bufferedReader.readLine();
        String result = Result1.decode(encoded);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
