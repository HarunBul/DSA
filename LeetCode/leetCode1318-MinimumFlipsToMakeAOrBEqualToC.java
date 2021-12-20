/**
 * 1318. Minimum Flips to Make a OR b Equal to c
 * 
 * Given 3 positives numbers a, b and c. Return the minimum flips required in
 * some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * 
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0
 * to 1 in their binary representation.
 */

class Solution {
    public int minFlips(int a, int b, int c) {
        int largestNum = Math.max(a, Math.max(b, c));
        int flipCount = 0;
        
        for (int i = 0; largestNum > 0; i++, largestNum >>>= 1) {
            int aBit = getIthBit(a, i);
            int bBit = getIthBit(b, i);
            int cBit = getIthBit(c, i);
            
            if (cBit == 0) {
                if ((aBit & bBit) == 1) flipCount += 2; // both 1
                else if ((aBit ^ bBit) == 1) flipCount += 1; // either 1
            } else {
                if ((aBit | bBit) == 0) flipCount += 1; // neither 1
            }
        }
        
        return flipCount;
    }
    
    public int getIthBit(int num, int i) {
        return (num & (1 << i)) >> i;
    }
}

/**
 * Notes:
 * 
 * Want to improve on incorporating helper functions into my code.
 * 
 * Have to be very careful when "looping" through binary numbers to update them
 * the right way and ensure the loops work as intended.
 * 
 * Important to thoroughly test beforehand. Paper/whiteboard helps.
 */
