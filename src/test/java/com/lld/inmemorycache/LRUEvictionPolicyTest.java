package com.lld.inmemorycache;

import com.lld.inmemorycache.policies.LRUEvictionPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LRUEvictionPolicyTest {
    private LRUEvictionPolicy<Integer> lruEvictionPolicy;

    @BeforeEach
    void init(){
        lruEvictionPolicy = new LRUEvictionPolicy<>();
    }

    @Test
    void testNoKeyToEvictInitially(){
        assertNull(lruEvictionPolicy.evictKey());
    }

    @Test
    void testEvictionKeyOrderInWhichOrderKeysAccessed(){
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);
        lruEvictionPolicy.keyAccessed(5);
        assertEquals(1,lruEvictionPolicy.evictKey());
        assertEquals(2,lruEvictionPolicy.evictKey());
    }

    @Test
    void testReaccessingKeyPreventsItFromEviction() {
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        lruEvictionPolicy.keyAccessed(3);
        lruEvictionPolicy.keyAccessed(4);
        lruEvictionPolicy.keyAccessed(5);
        lruEvictionPolicy.keyAccessed(1);
        lruEvictionPolicy.keyAccessed(2);
        assertEquals(3,lruEvictionPolicy.evictKey());
        assertEquals(4,lruEvictionPolicy.evictKey());
    }
}
