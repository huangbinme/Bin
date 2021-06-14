package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_43 {

    Map<Integer,String> map = new HashMap<>();

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        String ans = "0";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder mulSb = new StringBuilder(calMul(num1, num2.charAt(i) - '0'));
            for (int j = i; j < num2.length() - 1; j++) {
                mulSb.append("0");
            }
            ans = add(ans, mulSb.toString());
        }
        return ans;
    }

    private String calMul(String num1, int num) {
        if(map.containsKey(num)) return map.get(num);
        StringBuilder sb = new StringBuilder();
        int index = num1.length() - 1, carry = 0;
        while (index >= 0 || carry != 0) {
            int mul = index >= 0 ? (num1.charAt(index--) - '0') * num : 0;
            int cur = (mul + carry) % 10;
            carry = (mul + carry) / 10;
            sb.insert(0, cur);
        }
        map.put(num,sb.toString());
        return sb.toString();
    }

    private String add(String n1, String n2) {
        StringBuilder sb = new StringBuilder();
        int n1_index = n1.length() - 1, n2_index = n2.length() - 1, carry = 0;
        while (n1_index >= 0 || n2_index >= 0 || carry != 0) {
            int a = n1_index >= 0 ? n1.charAt(n1_index--) - '0' : 0;
            int b = n2_index >= 0 ? n2.charAt(n2_index--) - '0' : 0;
            int num = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            sb.insert(0, num);
        }
        return sb.toString();
    }
}
