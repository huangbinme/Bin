package com.review;

public class Solution_91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int a = 1, b = 0;
        for (int i = 1; i < s.length(); i++) {
            int curNum = s.charAt(i) - '0', preNum = s.charAt(i - 1) - '0';
            if (curNum == 0) {
                if (preNum == 1 || preNum == 2) {
                    b = a;
                    a = 0;
                } else {
                    return 0;
                }
            } else if (preNum == 1 || (preNum == 2 && 0 <= curNum && curNum <= 6)) {
                int tmpA = a, tmpB = b;
                a = tmpA + tmpB;
                b = tmpA;
            } else {
                a = a + b;
                b = 0;
            }
        }
        return a + b;
    }
}
