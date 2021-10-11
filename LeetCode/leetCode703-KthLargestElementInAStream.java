/*
 * 703. Kth Largest Element in a Stream:
 * 
 * Design a class to find the kth largest element in a stream. Note that it is 
 * the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Implement KthLargest class:
 * 
 * - KthLargest(int k, int[] nums) Initializes the object with the integer k 
 *      and the stream of integers nums.
 * - int add(int val) Appends the integer val to the stream and returns the 
 *      element representing the kth largest element in the stream.
 */

class KthLargest {
    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int n : nums) {
            this.heap.offer(n);
            if (this.heap.size() > k) {
                this.heap.poll();
            }
        }
    }
    
    public int add(int val) {        
        this.heap.offer(val);
        if (this.heap.size() > k) {
            this.heap.poll();
        }
        return this.heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

/**
 * Notes:
 * 
 * Need to remember that a min-heap keeps the K "max" elements and vice versa.
 * 
 * Good exercise for distinguishing between the different PQ methods.
 */
