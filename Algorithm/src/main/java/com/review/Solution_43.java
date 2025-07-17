package com.review;

public class Solution_43 {
    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder("0");
        for (int i = 0; i < num2.length(); i++) {
            int plusZero = num2.length() - 1 - i;
            StringBuilder addStr = mutiply(num1, num2.charAt(i));
            for (int j = 0; j < plusZero; j++) {
                addStr.append("0");
            }
            ans = add(ans, addStr);
        }
        return ans.charAt(0) == '0' ? "0" : ans.toString();
    }

    private StringBuilder add(StringBuilder s1, StringBuilder s2) {
        StringBuilder res = new StringBuilder();
        int maxMinus = Math.max(s1.length() - 1, s2.length() - 1), carry = 0;
        for (int i = 0; i <= maxMinus; i++) {
            int s1Num = s1.length() - 1 - i >= 0 ? s1.charAt(s1.length() - 1 - i) - '0' : 0;
            int s2Num = s2.length() - 1 - i >= 0 ? s2.charAt(s2.length() - 1 - i) - '0' : 0;
            int sum = carry + s1Num + s2Num;
            carry = sum / 10;
            char c = (char) ('0' + sum % 10);
            res.insert(0, c);
            if (i == maxMinus && carry > 0) {
                res.insert(0, carry);
            }
        }
        return res;
    }

    private StringBuilder mutiply(String num1, char c) {
        int n = c - '0';
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int j = num1.charAt(i) - '0';
            int k = j * n + carry;
            carry = k / 10;
            ans.insert(0, k % 10);
            if (i == 0 && carry > 0) ans.insert(0, carry);
        }
        return ans;
    }
}
