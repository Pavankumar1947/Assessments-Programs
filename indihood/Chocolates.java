package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chocolates {
	 public static void main(String args[]) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String[] firstLine = br.readLine().trim().split(" ");
	        int N = Integer.parseInt(firstLine[0]);
	        int M = Integer.parseInt(firstLine[1]);

	        long[] jars = new long[N + 1]; 
	        for (int i = 0; i < M; i++) {
	            String[] operation = br.readLine().trim().split(" ");
	            int left = Integer.parseInt(operation[0]);
	            int right = Integer.parseInt(operation[1]);
	            int chocolates = Integer.parseInt(operation[2]);

	            jars[left] += chocolates; 
	            if (right + 1 <= N) {
	            }
	        }

	        long totalChocolates = 0;
	        long current = 0;
	        for (int i = 1; i <= N; i++) {
	            current += jars[i];
	            totalChocolates += current;
	        }
	        System.out.println(totalChocolates / N);
	    }
}
