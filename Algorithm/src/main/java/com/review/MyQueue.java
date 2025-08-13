package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {

    Deque<Integer> forPush = new LinkedList<>();
    Deque<Integer> forPop = new LinkedList<>();


    public MyQueue() {

    }

    public void push(int x) {
        while (!forPop.isEmpty()) {
            forPush.offerLast(forPop.pollLast());
        }
        forPush.offerLast(x);

        while (!forPush.isEmpty()){
            forPop.offerLast(forPush.pollLast());
        }
    }

    public int pop() {
        return forPop.pollLast();
    }

    public int peek() {
        return forPop.peekLast();
    }

    public boolean empty() {
        return forPop.isEmpty();
    }
}
