package com.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_1104 {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> ans = new LinkedList<>();
        while (label != 0) {
            ans.offerFirst(label);
            label /= 2;
        }
        int loop = 1;
        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 != 0) {
                int num = ans.get(i);
                int newNum = loop * 2 - 1 - (num - loop);
                ans.set(i,newNum);
            }
            loop *= 2;
        }
        return ans;
    }
}
