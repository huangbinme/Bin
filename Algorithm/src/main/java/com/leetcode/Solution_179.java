package com.leetcode;

import java.util.Arrays;

public class Solution_179 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, (s1, s2) -> {
            String ns1 = s1 + s2, ns2 = s2 + s1;
            return -1 * ns1.compareTo(ns2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            sb.append(strings[i]);
        }
        return "0".equals(strings[0]) ? "0" : sb.toString();
    }
}
