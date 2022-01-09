package com.leetcode;

public class Solution_1629 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int time = releaseTimes[0];
        char ans = keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            if (releaseTimes[i] - releaseTimes[i - 1] > time) {
                time = releaseTimes[i] - releaseTimes[i - 1];
                ans = keysPressed.charAt(i);
            } else if (releaseTimes[i] - releaseTimes[i - 1] == time && keysPressed.charAt(i) - ans > 0) {
                ans = keysPressed.charAt(i);
            }
        }
        return ans;
    }
}
