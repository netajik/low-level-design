package com.lld.inmemorycache.caches;

import com.lld.inmemorycache.exception.NotFoundException;
import com.lld.inmemorycache.exception.StorageFullException;
import com.lld.inmemorycache.policies.EvictionPolicy;
import com.lld.inmemorycache.storage.Storage;

public class LRUCache<Key, Value> {
    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;

    public LRUCache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy){
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value){
        try {
            this.storage.add(key,value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException storageFullException) {
            System.out.println("Got storage full. Will try to evict.");
            Key keyToRemove = this.evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }
            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key,value);
        }
    }

    public Value get(Key key){
        try{
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}
