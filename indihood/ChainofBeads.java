package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChainofBeads {// chain of Beads
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

        int N = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split(" ");
        int maxSum = Integer.MIN_VALUE; 
        int currentSum = 0; 
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(input[i]); 
            currentSum = Math.max(value, currentSum + value);
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println(maxSum);
    }

}
