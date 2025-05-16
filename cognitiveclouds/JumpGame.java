package cognitiveclouds;

public class JumpGame {   // leet code programm
	
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; 
            maxReach = Math.max(maxReach, i + nums[i]); 
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame game = new JumpGame();

        // Test case 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Can jump (Test 1): " + game.canJump(nums1)); // return true

        // Test case 2
        int[] nums2 = {3, 2, 1, 0, 4};
        System.out.println("Can jump (Test 2): " + game.canJump(nums2)); // false

        // Test case 3
        int[] nums3 = {0};
        System.out.println("Can jump (Test 3): " + game.canJump(nums3)); // true

        // Test case 4
        int[] nums4 = {2, 0, 0};
        System.out.println("Can jump (Test 4): " + game.canJump(nums4)); // true
    }

}
