package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_1134 {
    public boolean isArmstrong(int n) {
        List<Integer> list = new ArrayList<>();
        int copy = n, k = 0, sum = 0;
        while (n != 0) {
            k++;
            if (n == 10) {
                n = 1;
            } else if (n < 10) {
                list.add(n);
                n = 0;
            } else {
                list.add(n % 10);
                n /= 10;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            sum += Math.pow(list.get(i), k);
        }
        return sum == copy;
    }
}
