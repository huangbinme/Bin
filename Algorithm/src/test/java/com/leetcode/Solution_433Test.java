package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_433Test {

    @Test
    public void testMinMutation() {
        Solution_433 solution_433 = new Solution_433();
        System.out.println(solution_433.minMutation("AACCGGTT","AAACGGTA",new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }
}