package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CollegeTrip {    // college trip
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int A = Integer.parseInt(firstLine[1]);
        int M = Integer.parseInt(firstLine[2]);
        int[] buses = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            buses[i] = (int) (Math.pow(A, i + 1) % M); // (A^i) % M
            sum += buses[i];
        }
        int Q = Integer.parseInt(br.readLine());
        int totalIndexSum = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < Q; i++) {
            int K = Integer.parseInt(br.readLine());
            int index = -1;
            int cumulativeSum = 0;
            for (int j = 0; j < N; j++) {
                cumulativeSum += buses[j];
                if (K <= cumulativeSum) {
                    index = j + 1; 
                    break;
                }}
            totalIndexSum = (totalIndexSum + index) % MOD;
        }
        System.out.println(totalIndexSum);
    }}
