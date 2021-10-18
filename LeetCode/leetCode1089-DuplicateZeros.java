/*
 * 1089. Duplicate Zeros:
 * 
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, 
 * shifting the remaining elements to the right.
 * 
 * Note that elements beyond the length of the original array are not written. 
 * Do the above modifications to the input array in place and do not return 
 * anything.
 */

class Solution {
    public void duplicateZeros(int[] arr) {
        int[] copy = new int[arr.length + 1];

        // make a copy of the input array with duplicate zeros
        copy[0] = arr[0];
        for (int i = 1, j = 1; i < arr.length && j + 1 < copy.length; i++, j++) {
            if (arr[i - 1] == 0) {
                // if previous element 0, first duplicate 0 in copy array
                copy[j] = 0;
                // then copy the following element in the input array
                copy[j + 1] = arr[i];
                j++;
            } else {
                // if previous element NOT zero, simply copy from the input array
                copy[j] = arr[i];
            }
        }
        
        // Modify the input array in place by copying over from the copy array
        for (int a = 0; a < arr.length; a++) {
            arr[a] = copy[a];
        }
    }
}

/**
 * Notes:
 * 
 * Time complexity O(n) and space complexity O(n) as well due to copy array.
 * 
 * Possible to reach O(1) space complexity by truncating input array based on
 * the number of zeros and then reassigning in place, but I found this approach
 * more intuitive while coding.
 */
