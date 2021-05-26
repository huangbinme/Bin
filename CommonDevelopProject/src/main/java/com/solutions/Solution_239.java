package com.solutions;

import java.util.LinkedList;

public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            add(list, nums[r++]);
            if (r - l == k) {
                ans[l] = list.peek();
                if (nums[l] == ans[l]) {
                    list.pollFirst();
                }
                l++;
            }
        }
        return ans;
    }

    private void add(LinkedList<Integer> list, int num) {
        while (list.size() != 0 && list.peekLast() < num) {
            list.pollLast();
        }
        list.offerLast(num);
    }
}
