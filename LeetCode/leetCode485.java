/*
Given a binary array nums, return the maximum number of consecutive 1's in the
array.
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current += 1;
            } else {
                if (current > max) {
                    max = current;
                }
                current = 0;
            }
        }
        return Math.max(max, current);
    }
}