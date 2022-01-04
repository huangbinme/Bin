package com.leetcode;

public class Solution_1185 {
    static String[] w = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    static int[] m = new int[]{0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int dayCount = 0;
        for (int i = 1971; i < year; i++) {
            dayCount += dayCount(i);
        }
        for (int i = 1; i < month; i++) {
            dayCount += dayCount(year, i);
        }
        dayCount += day - 1;
        return w[(dayCount + 4) % 7];
    }

    private int dayCount(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 366 : 365;
    }

    private int dayCount(int year, int month) {
        return month != 2 ? m[month - 1] : ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28);
    }
}
