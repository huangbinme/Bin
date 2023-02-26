package com.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> deque = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peekFirst()[0] <= temperatures[i]) {
                deque.pollFirst();
            }
            if (deque.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = deque.peekFirst()[1] - i;
            }
            deque.offerFirst(new int[]{temperatures[i], i});
        }
        return ans;
    }

    public int[] leftRigthDifference(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] ans = new int[nums.length];
        ans[0] = sum - nums[0];
        ans[ans.length - 1] = sum - nums[nums.length - 1];
        if (ans.length >= 3) {
            int l = nums[0], r = sum - nums[0] - nums[1];
            for (int i = 1; i < ans.length - 1; i++) {
                ans[i] = Math.abs(r - l);
                l += nums[i];
                r -= nums[i];
            }
        }
        return ans;
    }

    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        long remain = (word.charAt(0) - '0') % m;
        ans[0] = remain == 0 ? 1 : 0;
        for (int i = 1; i < word.length(); i++) {
            if (ans[i - 1] == 1) {
                ans[i] = (word.charAt(i) - '0') % m == 0 ? 1 : 0;
                remain = word.charAt(i) - '0';
            } else {
                long j = remain * 10 + (word.charAt(i) - '0');
                ans[i] = j % m == 0 ? 1 : 0;
                remain = j % m;
            }
        }
        return ans;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length / 2 - 1, r = nums.length - 1, ans = 0, maxR = l + 1;
        while (l >= 0 && r >= maxR) {
            if (nums[l] * 2 <= nums[r]) {
                ans += 2;
                r--;
                l--;
            } else {
                r--;
            }
        }
        return ans;
    }
}
