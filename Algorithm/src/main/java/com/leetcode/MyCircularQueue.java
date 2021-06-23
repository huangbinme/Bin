package com.leetcode;

public class MyCircularQueue {
    int[] ints;
    int head;
    int tail;

    public MyCircularQueue(int k) {
        ints = new int[k + 1];
        head = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        ints[tail] = value;
        tail = increaseOne(tail);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        ints[head] = 0;
        head = increaseOne(head);
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return ints[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return ints[decreaseOne(tail)];
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return head == increaseOne(tail);
    }

    private int increaseOne(int i) {
        if (i == ints.length - 1) return 0;
        return ++i;
    }

    private int decreaseOne(int i) {
        if (i == 0) return ints.length - 1;
        return --i;
    }
}
