package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);
        for (int i = 1; i < n; i++) {
            int p = ans.size() - 1;
            while (p >= 0) {
                ans.add(ans.get(p--) + (1 << i));
            }
        }
        return ans;
    }
}
