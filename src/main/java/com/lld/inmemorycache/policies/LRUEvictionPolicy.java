package com.lld.inmemorycache.policies;

import com.lld.inmemorycache.algorithms.DoublyLinkedList;
import com.lld.inmemorycache.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Eviction policy based on LRU algorithm.
 *
 * @param <Key> Key type.
 */
public class LRUEvictionPolicy<Key> implements  EvictionPolicy<Key> {

    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy(){
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(mapper.containsKey(key)){
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key,newNode);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = dll.getFirstNode();
        if(node == null){
            return null;
        }
        dll.detachNode(node);
        mapper.remove(node.getElement());
        return node.getElement();
    }
}
