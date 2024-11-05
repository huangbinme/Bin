package com.leetcode;

public class Solution_3222 {
    public String losingPlayer(int x, int y) {
        int k = Math.min(x, y / 4);
        return k % 2 == 1 ? "Alice" : "Bob";
    }
}
