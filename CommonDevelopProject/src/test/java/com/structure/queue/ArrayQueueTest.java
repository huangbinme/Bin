package com.structure.queue;

public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue<Integer> ArrayQueue = new ArrayQueue(1);
        ArrayQueue.enqueue(1);
        System.out.println(ArrayQueue);
        ArrayQueue.enqueue(2);
        System.out.println(ArrayQueue);
        ArrayQueue.enqueue(3);
        System.out.println(ArrayQueue);
        ArrayQueue.enqueue(4);
        System.out.println(ArrayQueue);
        ArrayQueue.enqueue(5);
        System.out.println(ArrayQueue);
        ArrayQueue.enqueue(6);
        System.out.println(ArrayQueue);
        ArrayQueue.dequeue();
        System.out.println(ArrayQueue);
        ArrayQueue.dequeue();
        System.out.println(ArrayQueue);
        ArrayQueue.dequeue();
        System.out.println(ArrayQueue);
        ArrayQueue.dequeue();
        System.out.println(ArrayQueue);
        ArrayQueue.dequeue();
        System.out.println(ArrayQueue);
        ArrayQueue.dequeue();
        System.out.println(ArrayQueue);
    }
}