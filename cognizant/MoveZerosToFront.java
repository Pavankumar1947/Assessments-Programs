package cognizant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZerosToFront {
	public static void main(String[] args) {
		int [] arr = {3,0,4,6,2,0,0,9};
		System.out.println(Arrays.toString(arr));
		
		moveZerosToFront(arr);
		
		System.out.println(Arrays.toString(arr));
		
	}

	private static void moveZerosToFront(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int num:arr) {
			if(num == 0)list.add(num);
		}
		
		for(int num : arr) {
			if(num !=0)list.add(num);
		}
		
		for(int i=0; i<arr.length; i++) {  // Convert list back to array
			arr[i] = list.get(i);
		}
		
	}

}
