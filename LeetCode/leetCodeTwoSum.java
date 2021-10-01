/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * You can return the answer in any order.
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<Integer, Integer>();
        int[] sumIndices = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            if (complements.containsKey(target - nums[i])) {
                sumIndices[0] = i;
                sumIndices[1] = complements.get(target - nums[i]);
                break;
            }
            complements.put(nums[i], i);
        }
        return sumIndices;
    }
}

/*
 * Notes:
 * 
 * Could have returned null and initialized array in return statement within
 * the loop, saving a few lines of code.
 * 
 * Unique pairs variant would proceed similarly but rely on a HashSet.
 */