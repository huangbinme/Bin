package com.algorithm.heap.queue;

public interface MaxPriorityQueue<E extends Comparable> {
    void insert(E key);
    E delMax();
    E max();
    boolean isEmpty();
    int size();
}
