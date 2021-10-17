/*
 * 696. Count Binary Substrings:
 * 
 * Given a binary string s, return the number of non-empty substrings that have
 * the same number of 0's and 1's, and all the 0's and all the 1's in these 
 * substrings are grouped consecutively.
 * 
 * Substrings that occur multiple times are counted the number of times they 
 * occur.
 */

class Solution {
    public int countBinarySubstrings(String s) {
        int numSubstrings = 0;
        
        int currentChunk = 1;
        int previousChunk = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentChunk++;
            } else {
                numSubstrings += Math.min(currentChunk, previousChunk);
                previousChunk = currentChunk;
                currentChunk = 1;
            }
        }

        return numSubstrings + Math.min(currentChunk, previousChunk);
    }
}

/**
 * Notes:
 * 
 * Important to think about what happens at the end of the loop, i.e. whether
 * an additional operation is required before returning.
 */
