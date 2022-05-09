package com.leetcode;

import java.util.*;

public class Solution_2259 {
    public String removeDigit(String number, char digit) {
        String ans = "0";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                StringBuilder sb = new StringBuilder(number);
                sb.deleteCharAt(i);
                String sub = sb.toString();
                if (ans.compareTo(sub) < 0) {
                    ans = sub;
                }
            }
        }
        return ans;
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, ans = Integer.MAX_VALUE;
        while (r < cards.length) {
            if (map.containsKey(cards[r])) {
                ans = Math.min(ans, r - map.get(cards[r]) + 1);
                while (map.containsKey(cards[r])) {
                    map.remove(cards[l++]);
                }
            }
            map.put(cards[r], r);
            r++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int countDistinct(int[] nums, int k, int p) {
        Set<List<Integer>> set = new HashSet<>();
        int l = 0, r = 0, c = 0;
        while (r < nums.length) {
            while (nums[r] % p == 0 && c == k && l < r) {
                if (nums[l++] % p == 0) c--;
            }
            for (int i = r; i >= l; i--) {
                List<Integer> list = new ArrayList<>();
                for (int j = i; j <= r; j++) {
                    list.add(nums[j]);
                }
                set.add(list);
            }
            if (nums[r] % p == 0) c++;
            r++;
        }
        return set.size();
    }
}
