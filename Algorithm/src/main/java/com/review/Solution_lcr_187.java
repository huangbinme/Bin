package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_lcr_187 {
    public int iceBreakingGame(int num, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        int remove = 0;
        while (list.size() != 1) {
            remove = (remove + target - 1) % list.size();
            list.remove(remove);
        }
        return list.get(0);
    }
}
