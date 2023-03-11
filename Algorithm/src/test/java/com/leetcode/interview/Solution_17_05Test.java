package com.leetcode.interview;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class Solution_17_05Test {

    @Test
    public void testFindLongestSubarray() {
        Solution_17_05 solution1705 = new Solution_17_05();
        System.out.println(Arrays.toString(solution1705.findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
    }
}