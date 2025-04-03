package mavenier;

import java.util.Arrays;

public class MissingNumberInAnArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 5, 6};
        int n = 6;
        System.out.println("Missing Number: " + findMissingNumber(arr, n));
	}

	private static int findMissingNumber(int[] arr, int n) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                return i + 1; 
            }
        }
        return n;
	}

}
