package com.lld.inmemorycache.storage;

import com.lld.inmemorycache.exception.NotFoundException;
import com.lld.inmemorycache.exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    final Integer capacity;

    public HashMapBasedStorage(Integer capacity){
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(this.isStorageFull()) throw  new StorageFullException("Storage Full...");
        this.storage.put(key, value);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!this.storage.containsKey(key)) throw new NotFoundException(key+" not exist in cache");
        return this.storage.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!this.storage.containsKey(key)) throw new NotFoundException(key+" not exist in cache");
        this.storage.remove(key);
    }

    private boolean isStorageFull(){
        return this.capacity == this.storage.size();
    }

}
