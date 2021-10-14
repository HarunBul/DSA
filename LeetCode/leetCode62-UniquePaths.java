/**
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in 
 * the diagram below).
 * 
 * How many possible unique paths are there?
 */

class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            if ( (prices[i] - minSoFar) > maxProfit ) {
                maxProfit = prices[i] - minSoFar;
            }
        }
        return maxProfit;
    }
}

/**
 * Notes:
 * 
 * DP as good approach for many "grid" questions.
 * 
 * Important to diagram and think "tile-by-tile" beforehand.
 */