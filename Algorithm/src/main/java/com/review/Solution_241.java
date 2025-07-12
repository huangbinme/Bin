package com.review;

import java.util.ArrayList;
import java.util.List;

public class Solution_241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (!(c - '0' >= 0 && c - '0' <= 9)) {
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i + 1));
                for (int j = 0; j < l.size(); j++) {
                    for (int k = 0; k < r.size(); k++) {
                        ans.add(operation(l.get(j), r.get(k), c));
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }

    private int operation(int i, int j, char c) {
        if (c == '-') {
            return i - j;
        } else if (c == '+') {
            return i + j;
        } else {
            return i * j;
        }
    }
}
