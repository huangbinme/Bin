package com;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int findVulnerabilityFactor(List<Integer> key, int maxChange) {
        if (key == null || key.isEmpty()) return 0;
        List<Integer> list = new ArrayList<>();
        int l = 0, r = 0;
        while (r < key.size()) {
            if (gcd(key.get(l), key.get(r)) == 1) {
                list.add(r - l);
                l = r;
            }
            r++;
        }
        list.add(r - l);
        int min = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i));
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (check(mid, list) <= maxChange) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static int check(int max, List<Integer> list) {
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            ans += (list.get(i) / (max + 1));
        }
        return ans;
    }

    public static int gcd(int i, int j) {
        if (j == 0) return i;
        return gcd(j, i % j);
    }
}
