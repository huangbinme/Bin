package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_1331 {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] copy = arr.clone();
        Arrays.sort(copy);
        int index = 1;
        for (int i = 0; i < copy.length; i++) {
            if (i > 0 && copy[i - 1] == copy[i]) continue;
            map.put(copy[i], index++);
        }
        for (int i = 0; i < copy.length; i++) {
            copy[i] = map.get(arr[i]);
        }
        return copy;
    }
}
