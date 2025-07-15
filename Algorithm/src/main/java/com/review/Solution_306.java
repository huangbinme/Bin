package com.review;

import java.math.BigInteger;

public class Solution_306 {

    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, null, null, 0);
    }

    private boolean dfs(String num, int start, BigInteger num1, BigInteger num2, int count) {
        if (start == num.length() && num1 != null && num2 != null && count >= 3) return true;
        for (int i = start; i < num.length(); i++) {
            String s = num.substring(start, i + 1);
            if (s.length() > 1 && s.charAt(0) == '0') continue;
            BigInteger curNum = new BigInteger(s);
            if (num1 == null) {
                boolean ans1 = dfs(num, i + 1, curNum, num2, 1);
                if (ans1) return true;
            } else if (num2 == null) {
                boolean ans2 = dfs(num, i + 1, num1, curNum, 2);
                if (ans2) return true;
            } else {
                BigInteger sum = num1.add(num2);
                if (sum.equals(curNum)) {
                    boolean ans3 = dfs(num, i + 1, num2, curNum, count + 1);
                    if (ans3) return true;
                }
            }
        }
        return false;
    }
}
