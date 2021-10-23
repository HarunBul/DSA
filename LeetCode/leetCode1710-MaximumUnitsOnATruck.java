/**
 * 1710. Maximum Units on a Truck
 * 
 * You are assigned to put some amount of boxes onto one truck. You are given a
 * 2D array boxTypes, where boxTypes[i] = [numberOfBoxes_i, numberOfUnitsPerBox_i]:
 * 
 * numberOfBoxes_i is the number of boxes of type i.
 * numberOfUnitsPerBox_i is the number of units in each box of the type i.
 * 
 * You are also given an integer truckSize, which is the maximum number of 
 * boxes that can be put on the truck. You can choose any boxes to put on the 
 * truck as long as the number of boxes does not exceed truckSize.
 * 
 * Return the maximum total number of units that can be put on the truck.
 */

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int total = 0;

        // sort boxTypes by the numberOfUnitsPerBox (decreasing)
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        for (int[] type : boxTypes) {
            // either load all units of largest box type left: type[0]
            // or as many units as can still fit into the truck: truckSize
            int boxesToLoad = Math.min(type[0], truckSize);
            total += boxesToLoad * type[1];

            // update remaining truckSize, quit if truck is full
            truckSize -= boxesToLoad;
            if (truckSize == 0) {
                break;
            }
        }

        return total;
    }
}

/*
 * Notes:
 * 
 * Useful practice for Array.sort() with lambda (arrow) expression.
 */