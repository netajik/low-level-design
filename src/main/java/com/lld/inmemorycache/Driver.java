package com.lld.inmemorycache;

import com.lld.inmemorycache.caches.LRUCache;
import com.lld.inmemorycache.factories.CacheFactory;

public class Driver {
    public static void main(String[] args) {

        LRUCache lruCache = new CacheFactory<Integer, Integer>().defaultCache(3);

        lruCache.put(1,1);
        lruCache.put(2,2);

        System.out.println(lruCache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        lruCache.put(3, 3);
        System.out.println(lruCache.get(3));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        lruCache.put(4, 4);

        System.out.println(lruCache.get(2)); // This should throw exception "Tried to access non-existing key."
    }
}
