package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < candyType.length; i++) {
            set.add(candyType[i]);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
