package com.lld.inmemorycache.factories;

import com.lld.inmemorycache.caches.LRUCache;
import com.lld.inmemorycache.policies.LRUEvictionPolicy;
import com.lld.inmemorycache.storage.HashMapBasedStorage;

public class CacheFactory<Key, Value> {
    public LRUCache<Key, Value> defaultCache(final Integer capacity){
        return new LRUCache<>(new HashMapBasedStorage<>(capacity),new LRUEvictionPolicy<>());
    }
}
