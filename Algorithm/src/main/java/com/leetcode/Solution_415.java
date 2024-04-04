package com.leetcode;

public class Solution_415 {
    public String addStrings(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            char c1 = i >= 0 ? num1.charAt(i--) : '0';
            char c2 = j >= 0 ? num2.charAt(j--) : '0';
            int sum = (c1 - '0') + (c2 - '0') + carry;
            int append = sum % 10;
            carry = sum / 10;
            ans.insert(0, append);
        }
        if(carry != 0) ans.insert(0, Integer.valueOf(carry));
        return ans.toString();
    }
}
