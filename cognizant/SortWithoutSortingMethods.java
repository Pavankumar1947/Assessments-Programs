package cognizant;

import java.util.Arrays;

public class SortWithoutSortingMethods {
	public static void main(String[] args) {
		int[] arr = {5, 2, 9, 1, 6, 3};
		
		System.out.println("Original Array: " + Arrays.toString(arr));

        bubbleSortAscending(arr);
        System.out.println("Ascending Order: " + Arrays.toString(arr));

        bubbleSortDescending(arr);
        System.out.println("Descending Order: " + Arrays.toString(arr));
	}

	private static void bubbleSortDescending(int[] arr) {
		// TODO Auto-generated method stub
		int n= arr.length;
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
				}
			}
		}
	}

	private static void bubbleSortAscending(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) { 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
	}

}
