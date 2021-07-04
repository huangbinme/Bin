package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_165 {
    public int compareVersion(String version1, String version2) {
        List<Integer> l1 = Arrays.stream(version1.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> l2 = Arrays.stream(version2.split("\\.")).map(Integer::valueOf).collect(Collectors.toList());
        int l1Cur = 0, l2Cur = 0;
        while (l1Cur < l1.size() || l2Cur < l2.size()) {
            int l1Num = l1.size() > l1Cur ? l1.get(l1Cur) : 0;
            int l2Num = l2.size() > l2Cur ? l2.get(l2Cur) : 0;
            if (l1Num > l2Num) {
                return -1;
            } else if (l1Num < l2Num) {
                return 1;
            }
            l1Cur++;
            l2Cur++;
        }
        return 0;
    }
}
