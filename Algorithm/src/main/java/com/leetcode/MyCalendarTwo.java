package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    List<int[]> list1 = new ArrayList<>();
    List<int[]> list2 = new ArrayList<>();

    public MyCalendarTwo() {
    }

    public boolean book(int startTime, int endTime) {
        for (int[] ints : list2) {
            if (cross(startTime, endTime, ints)) return false;
        }
        for (int[] ints : list1) {
            if (cross(startTime, endTime, ints)) {
                list2.add(new int[]{Math.max(startTime, ints[0]), Math.min(endTime, ints[1])});
            }
        }
        list1.add(new int[]{startTime, endTime});
        return true;
    }

    private boolean cross(int startTime, int endTime, int[] time) {
        return !(startTime >= time[1] || endTime <= time[0]);
    }
}
