package cognitiveclouds;

import java.util.HashMap;

public class HighestOccurringNoUsingHashMap {
	public static int findHighestOccurring(int[] arr) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxCount = 0, maxNum = arr[0];
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            if (freqMap.get(num) > maxCount) {
                maxCount = freqMap.get(num);
                maxNum = num;
            }
        }
        return maxNum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3, 4, 1, 3, 1, 1, 2, 2, 2, 2};
        System.out.println("Highest Occurring Number: " + findHighestOccurring(arr));
    }

}
