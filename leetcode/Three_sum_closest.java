package com.eclothing.clothing.leetcode;

/*
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).  */


import java.util.Arrays;

public class Three_sum_closest {
    public static void main(String[] args) {
        int [] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: sort array
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // initial sum

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                // If exact match, return immediately
                if (sum == target) return sum;

                // Update closestSum if current sum is closer
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                // Move pointers
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
