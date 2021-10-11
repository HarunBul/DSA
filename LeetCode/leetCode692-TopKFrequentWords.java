/*
 * 692. Top K Frequent Words:
 * 
 * Given an array of strings words and an integer k, return the k most frequent
 * strings.
 * 
 * Return the answer sorted by the frequency from highest to lowest. Sort the 
 * words with the same frequency by their lexicographical order.
 */

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }
        
        Queue<String> heap = new PriorityQueue<>((a, b) -> {
            int compValue = frequencies.get(a) - frequencies.get(b);
            if (compValue == 0) {
                // If frequency the same, place words in heap by lexicographical order
                return b.compareTo(a);
            } else {
                // Otherwise order by frequency
                return compValue;
            }
        });
        
        // Populate heap with input words and their frequencies, maintaining size k
        for (String word : frequencies.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        // Withdraw top K words into ArrayList, ordered lowest-to-highest
        List<String> output = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            output.add(heap.poll());
        }
        // Reverse ArrayList and return words ordered highest-to-lowest
        Collections.reverse(output);
        return output;
    }
}

/**
 * Notes:
 * 
 * Need to remember that .getOrDefault is a very useful method for populating
 * HashMaps.
 * 
 * To sort strings a and b by increasing lexicographical order, need to compare
 * b to a with .compareTo().
 */
