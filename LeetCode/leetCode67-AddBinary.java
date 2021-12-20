/**
 * 67. Add Binary
 * 
 * Given two binary strings a and b, return their sum as a binary string.
 */

class Solution {
    public String addBinary(String a, String b) {
        if (b.length() > a.length()) return addBinary(b, a);

    	int carryOver = 0;
	    StringBuilder sum = new StringBuilder();

    	for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--, j--) {
            char aChar = a.charAt(i);
            char bChar = (j >= 0 ? b.charAt(j) : '0');
            char newBit;
            
            if ( aChar == '0' && bChar == '0' ) {
                newBit = (carryOver == 1 ? '1' : '0');
                carryOver = 0;
            } else if ( ( aChar == '1' && bChar == '0' ) || ( aChar == '0' && bChar == '1' ) ) {      
                newBit = (carryOver == 1 ? '0' : '1');
            } else {
                newBit = (carryOver == 1 ? '1' : '0');
                carryOver = 1;
            }
            sum.append(newBit);
        }

	    if (carryOver == 1) sum.append('1');
	    return sum.reverse().toString();
    }
}

/**
 * Notes:
 * 
 * Had to review ternary operators a bit.
 * 
 * Will want to get more familiar with StringBuilder.
 */