package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!(c - '0' >= 0 && c - '0' <= 9)) {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        if (c == '+') {
                            ans.add(left.get(j) + right.get(k));
                        } else if (c == '-') {
                            ans.add(left.get(j) - right.get(k));
                        } else if (c == '*') {
                            ans.add(left.get(j) * right.get(k));
                        }
                    }
                }
            }
        }
        if (ans.isEmpty() && expression.length() != 0) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}
