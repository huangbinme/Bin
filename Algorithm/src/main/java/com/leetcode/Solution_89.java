package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(2);
        int z = 4;
        for (int i = 1; i < n; i++) {
            int fix = ans.size();
            for (int j = fix - 1; j >= 0; j--) {
                ans.add(ans.get(j) ^ z);
            }
            z *= 2;
        }
        return ans;
    }
}
