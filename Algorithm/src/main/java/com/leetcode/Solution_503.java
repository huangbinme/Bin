package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] copy = new int[nums.length * 2 - 1];
        int index = 0;
        for (int i = 0; i < copy.length; i++) {
            if (index == nums.length) index = 0;
            copy[i] = nums[index++];
        }
        int[] ans = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = copy.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && copy[i] >= deque.peekFirst()) {
                deque.pollFirst();
            }
            if(i < nums.length){
                ans[i] = deque.size() == 0 ? -1 : deque.peekFirst();
            }
            deque.offerFirst(copy[i]);
        }
        return ans;
    }
}
