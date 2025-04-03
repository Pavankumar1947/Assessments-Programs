package mavenier;

import java.util.Arrays;

public class SecondLargestNumber {
	public static void main(String[] args) {
        int[] arr = {10, 20, 4, 45, 99, 99, 5};
        System.out.println("Second Largest: " + findSecondLargest(arr));
    }
	
	public static int findSecondLargest(int[] arr) {
        Arrays.sort(arr);  
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != arr[arr.length - 1]) {
                return arr[i];
            }
        }
        return -1;  
    }

}
