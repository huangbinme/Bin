package com.leetcode;

public class Solution_415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            char num1_char = i >= 0 ? num1.charAt(i--) : '0';
            char num2_char = j >= 0 ? num2.charAt(j--) : '0';
            int result = (num1_char - '0') + (num2_char - '0') + carry;
            carry = result / 10;
            int cur = result % 10;
            sb.append(cur);
        }
        return carry == 0 ? sb.reverse().toString() : sb.append(carry).reverse().toString();
    }
}
