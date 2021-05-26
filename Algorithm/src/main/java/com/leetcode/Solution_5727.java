package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_5727 {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() != 1) {
            int removeIndex = getRemoveIndex(index, k, list);
            list.remove(removeIndex);
            index = removeIndex < list.size() ? removeIndex : 0;
        }
        return list.get(0) + 1;
    }

    private int getRemoveIndex(int index, int k, List<Integer> list) {
        return (index + k - 1) % list.size();
    }
}
