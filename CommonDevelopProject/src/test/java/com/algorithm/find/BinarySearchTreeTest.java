package com.algorithm.find;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

    public void testPut() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(1,"1");
        binarySearchTree.put(1,"2");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(7,"1");
        binarySearchTree.put(6,"1");
        binarySearchTree.put(5,"10");
        binarySearchTree.put(4,"1");
        assertEquals(8,binarySearchTree.size());
    }

    public void testGet() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"5");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(5,"hello");
        assertEquals("hello",binarySearchTree.get(5));
    }

    public void testDelete() {
    }

    public void testContains() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"5");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(5,"hello");
        assertEquals(true,binarySearchTree.contains(5));
    }

    public void testIsEmpty() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"5");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(5,"hello");
        assertEquals(false,binarySearchTree.isEmpty());
    }

    public void testSize() {
    }

    public void testMin() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(1,"1");
        binarySearchTree.put(1,"2");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(-3,"1");
        binarySearchTree.put(7,"1");
        binarySearchTree.put(6,"1");
        binarySearchTree.put(5,"10");
        binarySearchTree.put(4,"1");
        assertEquals(-3,binarySearchTree.min());
    }

    public void testMax() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(1,"1");
        binarySearchTree.put(1,"2");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(7,"1");
        binarySearchTree.put(6,"1");
        binarySearchTree.put(5,"10");
        binarySearchTree.put(4,"1");
        assertEquals(10,binarySearchTree.max());
    }

    public void testDeleteMin() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(1,"1");
        binarySearchTree.put(2,"2");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(4,"1");
        binarySearchTree.put(5,"1");
        binarySearchTree.deleteMin();
        assertEquals(2,binarySearchTree.min());
        assertEquals(4,binarySearchTree.size());
    }

    public void testDeleteMin2() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"1");
        binarySearchTree.put(2,"2");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(9,"1");
        assertEquals(1,binarySearchTree.min());
        binarySearchTree.deleteMin();
        assertEquals(2,binarySearchTree.min());
        assertEquals(5,binarySearchTree.size());
    }

    public void testDeleteMax() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"1");
        binarySearchTree.put(4,"2");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(2,"1");
        binarySearchTree.put(1,"1");        binarySearchTree.deleteMax();
        assertEquals(4,binarySearchTree.max());
        assertEquals(4,binarySearchTree.size());
    }

    public void testDeleteMax2() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"1");
        binarySearchTree.put(2,"2");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(11,"1");
        binarySearchTree.put(12,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(9,"1");
        binarySearchTree.put(8,"1");
        assertEquals(12,binarySearchTree.max());
        binarySearchTree.deleteMax();
        assertEquals(11,binarySearchTree.max());
        assertEquals(8,binarySearchTree.size());
    }

    public void testKeys() {
    }

    public void testPrint() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(5,"5");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(5,"hello");
        binarySearchTree.print();
    }
}