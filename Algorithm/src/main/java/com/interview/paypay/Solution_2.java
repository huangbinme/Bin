package com.interview.paypay;

public class Solution_2 {
    public int solution(String s) {
        // write your code here
        if(s.length() <= 1) return -1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < s.length()-1; i++) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
