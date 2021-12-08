/**
 * 1295. Find Numbers with Even Number of Digits
 * 
 * Given an array 'nums' of integers, return how many of them contain an even
 * number of digits.
 */

class Solution {
    public int findNumbers(int[] nums) {
        int evenNumDigits = 0;
        for (int i = 0; i < nums.length; i++) {
            int numDigits = 1;
            while (nums[i] >= 10) {
                nums[i] = nums[i] / 10;
                numDigits += 1;
            }
            if (numDigits % 2 == 0) evenNumDigits += 1;
        }
        return evenNumDigits;
    }
}

/**
 * Notes:
 * 
 * Will want to memorize the process for removing digits.
 */
