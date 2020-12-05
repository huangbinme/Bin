package com.algorithm.heap.queue;

import junit.framework.TestCase;

public class IntegerHeapMaxPQTest extends TestCase {

    public void testInsert() {
        IntegerHeapMaxPQ integerHeapMaxPQ = new IntegerHeapMaxPQ(10);
        integerHeapMaxPQ.insert(10);
        integerHeapMaxPQ.insert(9);
        integerHeapMaxPQ.insert(8);
        integerHeapMaxPQ.insert(7);
        integerHeapMaxPQ.insert(10);
        integerHeapMaxPQ.insert(6);
        integerHeapMaxPQ.insert(1);
        integerHeapMaxPQ.insert(-10);
        integerHeapMaxPQ.insert(-11);
        integerHeapMaxPQ.insert(8);
        integerHeapMaxPQ.print();
    }

    public void testDelMax() {
        IntegerHeapMaxPQ integerHeapMaxPQ = new IntegerHeapMaxPQ(10);
        integerHeapMaxPQ.insert(10);
        integerHeapMaxPQ.insert(9);
        integerHeapMaxPQ.insert(8);
        integerHeapMaxPQ.insert(7);
        integerHeapMaxPQ.insert(10);
        integerHeapMaxPQ.insert(6);
        integerHeapMaxPQ.insert(1);
        integerHeapMaxPQ.insert(-10);
        integerHeapMaxPQ.insert(-11);
        integerHeapMaxPQ.insert(8);
        integerHeapMaxPQ.print();
        integerHeapMaxPQ.delMax();
        integerHeapMaxPQ.print();
        integerHeapMaxPQ.delMax();
        integerHeapMaxPQ.print();
        integerHeapMaxPQ.delMax();
        integerHeapMaxPQ.print();
        integerHeapMaxPQ.delMax();
        integerHeapMaxPQ.print();
        integerHeapMaxPQ.delMax();
        integerHeapMaxPQ.print();
    }
}