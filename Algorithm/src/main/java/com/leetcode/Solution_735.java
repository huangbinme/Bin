package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            boolean currentAlive = true;
            while (!deque.isEmpty() && deque.peekLast() > 0 && asteroids[i] < 0) {
                if (deque.peekLast() == asteroids[i] * -1) {
                    deque.pollLast();
                    currentAlive = false;
                    break;
                } else if (deque.peekLast() > asteroids[i] * -1) {
                    currentAlive = false;
                    break;
                } else {
                    deque.pollLast();
                }
            }
            if (currentAlive) deque.offerLast(asteroids[i]);
        }
        int[] ans = new int[deque.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = deque.pollFirst();
        }
        return ans;
    }
}
