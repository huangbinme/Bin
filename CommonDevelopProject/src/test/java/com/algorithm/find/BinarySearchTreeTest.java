package com.algorithm.find;

import junit.framework.TestCase;

public class BinarySearchTreeTest extends TestCase {

    public void testPut() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5,"5");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(7,"1");
        binarySearchTree.put(6,"1");
        binarySearchTree.put(5,"10");
        binarySearchTree.put(4,"1");
    }

    public void testGet() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5,"5");
        binarySearchTree.put(1,"1");
        binarySearchTree.put(10,"1");
        binarySearchTree.put(8,"1");
        binarySearchTree.put(3,"1");
        binarySearchTree.put(7,"1");
        binarySearchTree.put(6,"1");
        binarySearchTree.put(5,"10");
        binarySearchTree.put(4,"1");
        System.out.println(binarySearchTree.get(5));
    }

    public void testDelete() {
    }

    public void testContains() {
    }
}