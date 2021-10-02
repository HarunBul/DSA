/*
 * A newly designed keypad was tested, where a tester pressed a sequence of n 
 * keys, one at a time.
 * 
 * You are given a string keysPressed of length n, where keysPressed[i] was the
 * ith key pressed in the testing sequence, and a sorted list releaseTimes, 
 * where releaseTimes[i] was the time the ith key was released. Both arrays are
 *  0-indexed. The 0th key was pressed at the time 0, and every subsequent key 
 * was pressed at the exact time the previous key was released.
 * 
 * The tester wants to know the key of the keypress that had the longest 
 * duration. The ith keypress had a duration of releaseTimes[i] - releaseTimes
 * [i - 1], and the 0th keypress had a duration of releaseTimes[0].
 * 
 * Note that the same key could have been pressed multiple times during the 
 * test, and these multiple presses of the same key may not have had the same 
 * duration.
 * 
 * Return the key of the keypress that had the longest duration. If there are 
 * multiple such keypresses, return the lexicographically largest key of the 
 * keypresses. 
*/

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        HashMap<Character, Integer> durations = new HashMap();
        char longestKey = ' ';
        int longestTime = 0;
        
        // populate map of key-longestTime pairs
        for (int i = 0; i < keysPressed.length(); i++) {
            // get current key and add to durations map if not yet present
            char currentKey = keysPressed.charAt(i);
            if (!durations.containsKey(currentKey)) {
                durations.put(keysPressed.charAt(i), 0);
            }
            
            // if key's latest time longer than previous longest, update map
            int currentDuration = durations.get(currentKey);
            int newDuration = releaseTimes[i] - (i > 0 ? releaseTimes[i - 1] : 0);
            durations.put(currentKey, Math.max(currentDuration, newDuration));
        }
        
        // iterate through map and identify key with longest time
        for (Map.Entry entry : durations.entrySet()) {
            int currentTime = (int) entry.getValue();
            char currentKey = (char) entry.getKey();
            
            if (currentTime > longestTime) {
                longestTime = currentTime;
                longestKey = currentKey;
            } else if (currentTime == longestTime && currentKey > longestKey) {
                longestKey = currentKey;
            }
        }
        
        return longestKey;
    }
}