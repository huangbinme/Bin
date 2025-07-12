package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_264 {

    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (n == 1) return 1;
        for (int i = 0; i < n - 1; i++) {
            int p2Num = 2 * list.get(p2);
            int p3Num = 3 * list.get(p3);
            int p5Num = 5 * list.get(p5);
            int min = Math.min(p2Num, Math.min(p3Num, p5Num));
            if (p2Num == min) p2++;
            if (p3Num == min) p3++;
            if (p5Num == min) p5++;
            list.add(min);
        }
        return list.get(list.size() - 1);
    }
}
