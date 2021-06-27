package com.leetcode.offer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_45 {
    public String minNumber(int[] nums) {
        List<String> strings = Arrays.stream(nums)
                .boxed()
                .map(String::valueOf)
                .sorted((a, b) -> (a + b).compareTo(b + a))
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }
}
