package com.lld.inmemorycache;

import com.lld.inmemorycache.caches.LRUCache;
import com.lld.inmemorycache.factories.CacheFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CacheTest {

    LRUCache lruCache;
    @BeforeEach
    public void setup(){
        lruCache = new CacheFactory<Integer, Integer>().defaultCache(3);
    }

    @Test
    void testItShouldBeAbleToGetAndAddItemsInTheCache() {
        lruCache.put(1,1);
        lruCache.put(2,2);

        assertEquals(1, lruCache.get(1)); // Accessing 1 after 2 got inserted which makes 2 the least recently used till now.
        lruCache.put(3, 3);
        assertEquals(3, lruCache.get(3));

        // Now if i try to add any element, the eviction should happen
        // Also eviction should happen based on LeastRecentlyUsedItem
        // which is 2 in this case.
        lruCache.put(4, 4);

        lruCache.get(2); // This should throw exception "Tried to access non-existing key."
    }
}
