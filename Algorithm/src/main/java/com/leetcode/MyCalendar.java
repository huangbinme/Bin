package com.leetcode;

import java.util.Comparator;
import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        treeMap = new TreeMap<>(Comparator.naturalOrder());
    }

    public boolean book(int start, int end) {
        Integer key1 = treeMap.ceilingKey(start);
        Integer key2 = treeMap.floorKey(start);
        if (key1 != null && !(key1 >= end || treeMap.get(key1) <= start)) return false;
        if (key2 != null && !(key2 >= end || treeMap.get(key2) <= start)) return false;
        treeMap.put(start, end);
        return true;
    }
}
