package com.leetcode.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> pushedDeque = new LinkedList<>();
        for (int i = 0; i < pushed.length; i++) {
            pushedDeque.offerLast(pushed[i]);
        }
        Deque<Integer> poppedDeque = new LinkedList<>();
        for (int i = 0; i < popped.length; i++) {
            while (poppedDeque.isEmpty() || poppedDeque.peekLast() != popped[i]) {
                if (pushedDeque.isEmpty()) return false;
                poppedDeque.offerLast(pushedDeque.pollFirst());
            }
            poppedDeque.pollLast();
        }
        return true;
    }
}
