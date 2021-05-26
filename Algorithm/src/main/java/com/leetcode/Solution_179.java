package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_179 {
    private static int compare(String s1, String s2) {
        return str1PlusStr2IsLarger(s1, s2) ? -1 : 1;
    }

    private static boolean str1PlusStr2IsLarger(String s1, String s2) {
        String num1 = s1 + s2;
        String num2 = s2 + s1;
        for (int i = 0; i < num1.length(); i++) {
            if (num1.charAt(i) != num2.charAt(i)) {
                return num1.charAt(i) - num2.charAt(i) >= 0;
            }
        }
        return true;
    }

    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, Solution_179::compare);
        return "0".equals(strings[0]) ? "0" : Arrays.stream(strings).collect(Collectors.joining());
    }
}
