package com.solutions;

public class Solution_91 {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int pre = 1;
        int next;
        if (s.charAt(1) == '0') {
            next = validate(s, 0, 2) ? 1 : 0;
        } else {
            next = validate(s, 1, 2) && validate(s, 0, 2) ? 2 : 1;
        }
        for (int i = 2; i < s.length(); i++) {
            if (pre == 0 && next == 0) return 0;
            int nextTmp = next;
            next = (validate(s, i - 1, i + 1) ? pre : 0) + (validate(s, i, i + 1) ? next : 0);
            pre = nextTmp;
        }
        return next;
    }

    private boolean validate(String s, int start, int end) {
        if (s.charAt(start) == '0') return false;
        if (end - start == 1) return true;
        return s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(end - 1) <= '6');
    }
}
