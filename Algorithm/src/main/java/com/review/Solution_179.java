package com.review;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_179 {
    public String largestNumber(int[] nums) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        collect.sort((a, b) -> {
            String s1 = a + String.valueOf(b);
            String s2 = b + String.valueOf(a);
            return s2.compareTo(s1);
        });
        StringBuilder ans = new StringBuilder();
        for (Integer integer : collect) {
            ans.append(integer);
        }
        return ans.charAt(0) == '0' ? "0" : ans.toString();
    }
}
