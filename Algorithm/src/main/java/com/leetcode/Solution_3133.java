package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_3133 {
    public long minEnd(int n, int x) {
        String bStr1 = Integer.toBinaryString(n - 1);
        String bStr2 = Integer.toBinaryString(x);
        StringBuilder sb2 = new StringBuilder(bStr2);
        List<Integer> zero = new ArrayList<>();
        for (int i = 0; i < sb2.length(); i++) {
            if (sb2.charAt(i) == '0') zero.add(i);
        }
        int j = bStr1.length() - 1;
        for (int i = zero.size() - 1; i >= 0; i--) {
            if (j >= 0) {
                sb2.setCharAt(zero.get(i), bStr1.charAt(j--));
            }
        }
        if (j >= 0) {
            sb2.insert(0, bStr1.substring(0, j + 1));
        }
        long res = 0;
        for (int k = 0; k < sb2.length(); k++) {
            if (sb2.charAt(k) == '1') {
                res += (long) Math.pow(2, sb2.length() - 1 - k);
            }
        }
        return res;
    }
}
