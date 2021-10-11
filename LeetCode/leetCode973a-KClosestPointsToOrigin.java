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
        // sort input array by Euclidean distance
        Arrays.sort(points, (a, b) -> {
            // calculate distance without sqrt to avoid doubles
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        });

        // create output array and populate from sorted input array
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
        }
        
        return result;
    }
}

/**
 * Notes:
 * 
 * Realized after submission I could've also skipped the for-loop and directly
 * returned via copyOfRange.
 * 
 * Will want to implement a heap version of this as well.
 */
