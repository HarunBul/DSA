/*
 * Write a function that takes a list of numbers and a target number, and then 
 * returns the number of unique pairs that add up to the target number.
*/

class Solution {
    public static int twoSumUniquePairs(List<Integer> nums, int target) {
        int uniquePairs = 0;
        Set<Integer> complements = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        
        for (Integer num : nums) {
            complements.add(num);
            if (complements.contains(target - num) && !seen.contains(num)) {
                uniquePairs++;
                seen.add(num);
                seen.add(target - num);
            }
        }
        return uniquePairs;
    }
}
