package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < rowIndex; i++) {
            if (i == 0) {
                list.add(1);
                continue;
            }
            int tmp = list.get(1);
            for (int j = 0; j < list.size() - 1; j++) {
                tmp = list.get(j + 1);
                list.add(list.get(j) + list.get(j + 1));
            }
            list.add(0, 1);
            list.add(1);
        }
        return list;
    }
}
