package com.review;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_227 {
    public int calculate(String s) {
        Deque<Character> operations = new LinkedList<>();
        Deque<Integer> nums = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (isNum(c)) {
                int numLast = i;
                while (numLast < s.length() && isNum(s.charAt(numLast))) {
                    numLast++;
                }
                int num = Integer.parseInt(s.substring(i, numLast));
                i = numLast - 1;
                if (nums.isEmpty()) {
                    nums.offerLast(num);
                } else {
                    if (operations.peekLast() == '*' || operations.peekLast() == '/') {
                        int num2 = nums.pollLast();
                        char operation = operations.pollLast();
                        nums.offerLast(operation(num2, num, operation));
                    } else {
                        nums.offerLast(num);
                    }
                }
            } else {
                operations.offerLast(c);
            }
        }
        int ans = 0;
        ans += nums.pollFirst();
        while (!nums.isEmpty()) {
            ans = operation(ans, nums.pollFirst(), operations.pollFirst());
        }
        return ans;
    }

    private boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    private int operation(int i, int j, char operation) {
        if (operation == '+') {
            return i + j;
        } else if (operation == '-') {
            return i - j;
        } else if (operation == '/') {
            return i / j;
        } else {
            return i * j;
        }
    }
}
