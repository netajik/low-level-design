package com.lld.inmemorycache;

import com.lld.inmemorycache.algorithms.DoublyLinkedList;
import com.lld.inmemorycache.algorithms.DoublyLinkedListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DoublyLinkedListTest {

    @Test
    public void testAddNodeLast() {
        DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
        DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
        DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
        DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addNodeAtLast(node1);
        dll.addNodeAtLast(node2);
        dll.addNodeAtLast(node3);
        dll.addNodeAtLast(node4);

        verify(dll, Arrays.asList(new Integer[]{1,2,3,4}));
    }

    @Test
   public void testDetachNode(){
        DoublyLinkedListNode<Integer> node1 = new DoublyLinkedListNode<>(1);
        DoublyLinkedListNode<Integer> node2 = new DoublyLinkedListNode<>(2);
        DoublyLinkedListNode<Integer> node3 = new DoublyLinkedListNode<>(3);
        DoublyLinkedListNode<Integer> node4 = new DoublyLinkedListNode<>(4);

        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll.addNodeAtLast(node1);
        dll.addNodeAtLast(node2);
        dll.addNodeAtLast(node3);
        dll.addNodeAtLast(node4);
        dll.detachNode(node1);

        verify(dll, Arrays.asList(new Integer[]{2,3,4}));
    }

    void verify(DoublyLinkedList<Integer> dll, List<Integer> list){
        DoublyLinkedListNode<Integer> currentNode = dll.getFirstNode();
        for(Integer element : list){
            Integer nodeValue = currentNode.getElement();
            assertEquals(element,nodeValue);
            currentNode = currentNode.getNext();
        }
        assertNull(currentNode.getElement());
    }
}
