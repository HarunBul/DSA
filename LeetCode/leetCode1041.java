/* 1041. Robot Bounded in Circle:
 * 
 * On an infinite plane, a robot initially stands at (0, 0) and faces north. 
 * The robot can receive one of three instructions:
 * 
 * - "G": go straight 1 unit;
 * - "L": turn 90 degrees to the left;
 * - "R": turn 90 degrees to the right.
 * 
 * The robot performs the instructions given in order, and repeats them forever.
 * 
 * Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.
 */

class Solution {
    public boolean isRobotBounded(String instructions) {
        int degrees = 0;
        int x = 0, y = 0;
        
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                degrees = (degrees - 90) % 360;
            } else if (instructions.charAt(i) == 'R') {
                degrees = (degrees + 90) % 360;
            } else {
                switch (Math.abs(degrees) % 360) {
                    case 0:
                        y++;
                        break;
                    case 90:
                        x++;
                        break;
                    case 180:
                        y--;
                        break;
                    case 270:
                        x--;
                        break;
                }
            }
        }
        // robot CAN be bounded if (1) not pointing north OR (2) back at origin
        return degrees != 0 || (x == 0 && y == 0);
    }
}

/*
 * Notes:
 * 
 * Important to think mathematically, in terms of cases.
 */
