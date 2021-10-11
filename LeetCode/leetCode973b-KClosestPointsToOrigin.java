/*
 * 973. K Closest Points to Origin:
 * 
 * Given an array of points where points[i] = [xi, yi] represents a point on 
 * the X-Y plane and an integer k, return the k closest points to the origin 
 * (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance 
 * (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be 
 * unique (except for the order that it is in).
 */

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //create max-heap of distance to origin
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
        });
        
        // insert each input point into the max-heap
        for (int[] point : points) {
            heap.add(point);
            
            // once heap > k, take out max dist, leaving k min (closest)
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        // create output array and populate w/ size-k heap
        int[][] output = new int[k][2];
        return heap.toArray(output);
    }
}

/**
 * Notes:
 * 
 * Heap implementation with PriorityQueue.
 * 
 * Getting more of a hang of lambda expressions for ordering/sorting.
 */
