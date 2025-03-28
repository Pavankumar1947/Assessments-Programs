package indihood;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubarrayCheck {  // subarray check
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputA = br.readLine().trim().split(","); 
        int[] A = new int[inputA.length];
        for (int i = 0; i < inputA.length; i++) {
            A[i] = Integer.parseInt(inputA[i].trim()); 
        }
        String[] inputB = br.readLine().trim().split(","); 
        int[] B = new int[inputB.length];
        for (int i = 0; i < inputB.length; i++) {
            B[i] = Integer.parseInt(inputB[i].trim()); 
        }
        System.out.println(isSubarray(A, B) ? "Yes" : "No");
    }

    private static boolean isSubarray(int[] A, int[] B) {
        int n = A.length, m = B.length;
        if (m > n) return false;
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && A[i + j] == B[j]) {
                j++;
            }
            if (j == m) return true; // Found B[] as a subarray
        }
        return false;
    }

}
