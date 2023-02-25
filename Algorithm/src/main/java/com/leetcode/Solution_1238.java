package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int indexStart = 0;
        for (int i = 1; i <= n; i++) {
            int size = list.size();
            for (int j = size - 1; j >= 0; j--) {
                int k = list.get(j) | (1 << i - 1);
                list.add(k);
                if (k == start) indexStart = list.size() - 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(indexStart % list.size()));
            indexStart++;
        }
        return ans;
    }
}
