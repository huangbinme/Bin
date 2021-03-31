package com.solutions;

import java.util.Arrays;

public class Solution_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        return find(intervals);
    }

    private int[][] find(int[][] intervals) {
        int newArrayLength = 1;
        for (int i = 1; i < intervals.length; i++) {
            if(canBeMerged(intervals,newArrayLength-1,i)){
                merge(intervals,newArrayLength-1,i);
            }else {
                intervals[newArrayLength][0] = intervals[i][0];
                intervals[newArrayLength][1] = intervals[i][1];
                newArrayLength++;
            }
        }
        int[][] newArray = new int[newArrayLength][2];
        System.arraycopy(intervals,0,newArray,0,newArrayLength);
        return newArray;
    }

    public boolean canBeMerged(int[][] intervals, int left, int right) {
        int left_b = intervals[left][1];
        int right_a = intervals[right][0];
        return left_b >= right_a;
    }

    public void merge(int[][] intervals, int left, int right) {
        int left_b = intervals[left][1];
        int right_b = intervals[right][1];
        intervals[left][1] = Math.max(left_b,right_b);
    }
}
