package com.leetcode;

import java.util.Arrays;

public class Solution_1356 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed()
                .sorted((a, b) -> {
                    int dif = count(a) - count(b);
                    return dif != 0 ? dif : (a - b);
                })
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private int count(int i) {
        int count = 0;
        while (i != 0 && i != 1) {
            if (i % 2 != 0) count++;
            i >>= 1;
        }
        return i == 0 ? count : count + 1;
    }
}
