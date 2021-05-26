package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TwoSum() {

    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Integer integer : map.keySet()) {
            int sub = value - integer;
            if (map.containsKey(sub) && (sub != integer || map.get(sub) > 1)) {
                return true;
            }
        }
        return false;
    }
}
