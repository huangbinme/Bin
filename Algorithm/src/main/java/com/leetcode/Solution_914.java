package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_914 {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        int x = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (x == -1) {
                x = entry.getValue();
            }else {
                x = gcd(x,entry.getValue());
            }
            if(x == 1) return false;
        }
        return true;
    }

    public int gcd(int i, int j) {
        if (j == 0) return i;
        return gcd(j, i % j);
    }
}
