package com.lld.inmemorycache.algorithms;

import lombok.Getter;

/**
 * Doubly LinkedList Node
 * @param <E>
 */
@Getter
public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public DoublyLinkedListNode(E element){
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}
