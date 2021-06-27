package com.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    Deque<Integer> in;
    Deque<Integer> out;

    public CQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    public void appendTail(int value) {
        while (!out.isEmpty()) {
            in.addLast(out.pollLast());
        }
        in.addLast(value);
    }

    public int deleteHead() {
        while (!in.isEmpty()) {
            out.addLast(in.pollLast());
        }
        return out.isEmpty() ? -1 : out.pollLast();
    }
}
