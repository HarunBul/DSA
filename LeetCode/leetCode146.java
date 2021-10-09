/**
 * Design a data structure that follows the constraints of a Least Recently 
 * Used (LRU) cache.
 * 
 * Implement the LRUCache class:
 * 
 *  - LRUCache(int capacity) Initialize the LRU cache with positive size 
 *      capacity.
 *  - int get(int key) Return the value of the key if the key exists, otherwise
 *      return -1.
 *  - void put(int key, int value) Update the value of the key if the key 
 *      exists. Otherwise, add the key-value pair to the cache. If the number 
 *      of keys exceeds the capacity from this operation, evict the least 
 *      recently used key.
 * 
 * The functions get and put must each run in O(1) average time complexity.
 */

import java.util.LinkedHashMap;

class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */