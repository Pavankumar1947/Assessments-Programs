package Benison;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] resu = {2, 7, 11, 15};
		int target = 13;
        int[] result = twoSum(resu, target);
        System.out.println(Arrays.toString(result));
	}

	private static int[] twoSum(int[] resu, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i =0; i < resu.length; i++) {
			int ab = target - resu[i];
			
			if(map.containsKey(ab)) {
				return new int[] {map.get(ab),i};
			}
			map.put(resu[i], i);
		}
		return new int[] {};
	}
}
