package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(l, r, s);
            l++;
            r--;
        }
    }

    private void swap(int i, int j, char[] chars) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public long removeZeros(long n) {
        String s = Long.toString(n);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                ans.append(s.charAt(i));
            }
        }
        return Long.valueOf(ans.toString());
    }

    public long maxAlternatingSum(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        list.sort(Comparator.comparingInt(a -> Math.abs(a)));
        long ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i < nums.length / 2) {
                ans += list.get(i) * list.get(i) * -1;
            } else {
                ans += list.get(i) * list.get(i);
            }
        }
        return ans;
    }
}
