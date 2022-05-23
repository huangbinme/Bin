package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger * (maxChoosableInteger + 1) < (desiredTotal * 2)) {
            return false;
        }
        return dfs(0, maxChoosableInteger, desiredTotal, 0, new HashMap<>());
    }

    private boolean dfs(int state, int maxChoosableInteger, int desiredTotal, int count, Map<Integer, Boolean> map) {
        for (int i = 0; i < maxChoosableInteger; i++) {
            int check = state >> i, curNum = i + 1;
            if (check % 2 != 0) continue;
            if (curNum + count >= desiredTotal) return true;
            int curState = ((1 << i) | state);
            boolean re;
            if (map.containsKey(curState)) {
                re = map.get(curState);
            } else {
                re = dfs(curState, maxChoosableInteger, desiredTotal, count + curNum, map);
                map.put(curState, re);
            }
            if (!re) return true;
        }
        return false;
    }
}
