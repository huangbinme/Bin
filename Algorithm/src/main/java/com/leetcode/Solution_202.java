package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_202 {

    Set<Integer> set = new HashSet<>();

    public boolean isHappy(int n) {
        set.add(n);
        int next = 0;
        int tmp = n;
        while (tmp != 0) {
            next += (tmp % 10) * (tmp % 10);
            tmp /= 10;
        }
        if (next == 1) return true;
        return !set.contains(next) && isHappy(next);
    }
}
