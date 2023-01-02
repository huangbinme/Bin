package com.leetcode;

public class Solution_1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int oneCountStu = 0;
        for (int i = 0; i < students.length; i++) {
            oneCountStu += students[i];
        }
        int zeroCountStu = students.length - oneCountStu;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 1) {
                if (oneCountStu == 0) return sandwiches.length - i;
                oneCountStu--;
            } else {
                if (zeroCountStu == 0) return sandwiches.length - i;
                zeroCountStu--;
            }
        }
        return 0;
    }
}
