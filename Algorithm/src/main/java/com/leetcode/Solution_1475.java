package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1475 {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> deque = new LinkedList<>();
        int[] ans = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekFirst() > prices[i]){
                deque.pollFirst();
            }
            if(deque.isEmpty()){
                ans[i] = prices[i];
            }else {
                ans[i] = prices[i] - deque.peekFirst();
            }
            deque.offerFirst(prices[i]);
        }
        return ans;
    }
}
