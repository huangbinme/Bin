package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_lcr_170 {
    public int reversePairs(int[] record) {
        if (record == null || record.length == 1) return 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        list.add(record[record.length - 1]);
        for (int i = record.length - 2; i >= 0; i--) {
            int j = findThenInsert(record[i], list);
            ans += j;
        }
        return ans;
    }

    private int findThenInsert(int num, List<Integer> list) {
        int i = Collections.binarySearch(list, num);
        int addIndex = i < 0 ? i * -1 - 1 : i;
        list.add(addIndex, num);
        while (addIndex - 1 >= 0 && list.get(addIndex - 1) == num) addIndex--;
        return addIndex;
    }
}
