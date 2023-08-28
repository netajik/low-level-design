package com.lld.inmemorycache.algorithms;

import com.lld.inmemorycache.algorithms.exception.InvalidElementException;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {
    DoublyLinkedListNode<E> dummyHead;
    DoublyLinkedListNode<E> dummyTail;

    public DoublyLinkedList(){
        this.dummyHead = new DoublyLinkedListNode<>(null);
        this.dummyTail = new DoublyLinkedListNode<>(null);
        dummyTail.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * Method to detach a random node from the doubly linked list. The node itself will not be removed from the memory.
     * Just that it will be removed from the list and becomes orphaned.
     *
     * @param node Node to be detached
     */
    public void detachNode(DoublyLinkedListNode<E> node) {
        if(node !=null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    /**
     * Helper method to add a node at the end of the list.
     *
     * @param node Node to be added.
     */
    public void addNodeAtLast(DoublyLinkedListNode<E> node){
        node.prev = dummyTail.prev;
        node.prev.next = node;
        node.next = dummyTail;
        dummyTail.prev = node;
    }

    /**
     * Helper method to add an element at the end.
     *
     * @param element Element to be added.
     * @return Reference to new node created for the element.
     */
    public DoublyLinkedListNode<E> addElementAtLast(E element) throws InvalidElementException {
        if(element == null){
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    public boolean isItemPresent(){
        return dummyHead.next != dummyTail;
    }

    public DoublyLinkedListNode<E> getFirstNode() throws NoSuchElementException {
        if(!isItemPresent()) {
            return null;
        }
       return this.dummyHead.next;
    }

    public DoublyLinkedListNode<E> getLastNode() throws NoSuchElementException {
        if(!isItemPresent()) {
            return null;
        }
        return this.dummyTail.prev;
    }

}
