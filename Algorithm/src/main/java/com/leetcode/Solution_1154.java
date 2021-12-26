package com.leetcode;

public class Solution_1154 {
    static int[] ints = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] dateArray = date.split("-");
        ints[2] = Integer.parseInt(dateArray[0]) % 4 == 0 ? 29 : 28;
        int month = Integer.parseInt(dateArray[1]), ans = 0;
        for (int i = 0; i < month - 1; i++) {
            ans += ints[i];
        }
        ans += Integer.parseInt(dateArray[2]);
        return ans;
    }
}
