package com.structure.queue;

public class LinkListQueueTest {
    public static void main(String[] args) {
        LinkListQueue<Integer> LinkListQueue = new LinkListQueue();
        LinkListQueue.enqueue(1);
        System.out.println(LinkListQueue);
        LinkListQueue.enqueue(2);
        System.out.println(LinkListQueue);
        LinkListQueue.enqueue(3);
        System.out.println(LinkListQueue);
        LinkListQueue.enqueue(4);
        System.out.println(LinkListQueue);
        LinkListQueue.enqueue(5);
        System.out.println(LinkListQueue);
        LinkListQueue.enqueue(6);
        System.out.println(LinkListQueue);
        LinkListQueue.dequeue();
        System.out.println(LinkListQueue);
        LinkListQueue.dequeue();
        System.out.println(LinkListQueue);
        LinkListQueue.dequeue();
        System.out.println(LinkListQueue);
        LinkListQueue.dequeue();
        System.out.println(LinkListQueue);
        LinkListQueue.dequeue();
        System.out.println(LinkListQueue);
        LinkListQueue.dequeue();
        System.out.println(LinkListQueue);
    }
}