package com.interview.paypay;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1 {
    public String sumConsecutiveIdenticalDigits(String digits) {
        // write your code here
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            offer(deque, String.valueOf(digits.charAt(i)));
        }
        StringBuilder ans = new StringBuilder();
        while (!deque.isEmpty()) {
            ans.append(deque.pollFirst());
        }
        return ans.toString();
    }

    private void offer(Deque<Integer> deque, String s) {
        if (s == null || s.isEmpty()) return;
        String sub = s.substring(1);
        int firstNum = s.charAt(0) - '0';
        if (!deque.isEmpty() && deque.peekLast().equals(firstNum)) {
            int poll = deque.pollLast();
            int sum = poll + firstNum;
            String newS = sum + sub;
            offer(deque, newS);
        } else {
            deque.offerLast(firstNum);
            offer(deque, sub);
        }
    }
}
