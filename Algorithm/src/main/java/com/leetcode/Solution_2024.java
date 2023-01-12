package com.leetcode;

public class Solution_2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        //F is 0, T is 1
        int tCount = 0, l = 0, r = 0, ans = 1;
        while (r < answerKey.length()) {
            while (Math.min(tCount, r - l + 1 - tCount) > k) {
                if (answerKey.charAt(l) == 'T') tCount--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
            if (answerKey.charAt(r) == 'T') tCount++;
        }
        return ans;
    }
}
