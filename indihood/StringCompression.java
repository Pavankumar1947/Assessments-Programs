package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringCompression {  //String Compression
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String compressed = compressString(input);
        System.out.println(compressed.length() < input.length() ? compressed : input);
	}
	
	private static String compressString(String s) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append(s.charAt(s.length() - 1)).append(count);
        return compressed.toString();
    }

}
