/*
 * 937. Reorder Data in Log Files:
 * 
 * You are given an array of logs. Each log is a space-delimited string of 
 * words, where the first word is the identifier.
 * 
 * There are two types of logs:
 * 
 * - Letter-logs: All words (except the identifier) consist of lowercase 
 *      English letters.
 * - Digit-logs: All words (except the identifier) consist of digits.
 * 
 * Reorder these logs so that:
 * 
 * - The letter-logs come before all digit-logs.
 * - The letter-logs are sorted lexicographically by their contents. If their 
 *      contents are the same, then sort them lexicographically by their 
 *      identifiers.
 * - The digit-logs maintain their relative ordering.
 * 
 * Return the final order of the logs.
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            // Determine index of initial space delimiter
            int spaceDelimiter1 = log1.indexOf(" ");
            int spaceDelimiter2 = log2.indexOf(" ");
            
            // Isolate identifier of both logs
            String identifier1 = log1.substring(0, spaceDelimiter1);
            String identifier2 = log2.substring(0, spaceDelimiter2);
            
            // Isolate body of both logs
            String logContents1 = log1.substring(spaceDelimiter1 + 1);
            String logContents2 = log2.substring(spaceDelimiter2 + 1);
            
            // Determine whether logs are digit or not (i.e. letter)
            boolean isDigit1 = Character.isDigit(logContents1.charAt(0));
            boolean isDigit2 = Character.isDigit(logContents2.charAt(0));
            
            // If both are letter-logs:
            if (!isDigit1 && !isDigit2) {
                int compValue = logContents1.compareTo(logContents2);
                if (compValue == 0) {
                    // If bodies are the same, compare identifiers
                    return identifier1.compareTo(identifier2);
                } else {
                    // Otherwise, compare bodies
                    return compValue;
                }
            // If only one is a letter-log, it comes before the digit-log
            } else if (!isDigit1 && isDigit2) {
                return -1;
            } else if (isDigit1 && !isDigit2) {
                return 1;
            // // If both are digit-logs, maintain relative ordering
            } else {
                return 0;
            }
        });
        
        return logs;
    }
}

/**
 * Notes:
 * 
 * ...
 */
