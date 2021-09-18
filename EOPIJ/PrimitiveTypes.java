public class PrimitiveTypes {
    public static void main(String[] args) {
        System.out.println("countBits(5): " + countBits(5));
    }
      
    /**
     * Returns the number of 1 bits in a given int
     * 
     * @param x
     * @return numBits
     */
    public static short countBits(int x) {
        /* O(n): O(1) per bit * worst case # of 1 bits (all n bits) */
        short numBits = 0;
        while (x != 0) {
            /* First, isolate the LSB w/ bitwise AND. It'll only = 1 if x's LSB
             is 1; otherwise 0 */
            numBits += (x & 1);
            /* Right shift *logical* (adds leading 0), de facto moving to next 
             bit of X, e.g. 0101 > 0010 */
            x >>>= 1;
            /* Continue until, per while condition, x is just 0000 */
        }
        return numBits;
    }
}
