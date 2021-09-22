/*
 Given an integer array nums sorted in non-decreasing order, return an array of 
 the squares of each number sorted in non-decreasing order.
 */

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int current = nums.length - 1;
        int[] result = new int[nums.length];
        
        while (current >= 0) {
            if ( Math.abs(nums[j]) > Math.abs(nums[i]) ) {
                result[current] = nums[j]*nums[j];
                j--;
            } else {
                result[current] = nums[i]*nums[i];
                i++;
            }
            current--;
        }

        return result;
    }
}

/*
 Notes:
    I'll use "left" and "right" as more descriptive ptr names in the future.
    Would also turn While into For loop based on the "Current" variable.  
 */
