package com.leetcode;

import junit.framework.TestCase;

import java.util.stream.Collectors;

public class Solution_1461Test extends TestCase {

    public void testGetSubString() {
        Solution_1461 solution_1461 = new Solution_1461();
        System.out.println(solution_1461.getSubString(3).stream().map(s -> s.replace("Start->-1->","")).collect(Collectors.toList()));
        //System.out.println(solution_1461.getSubString(5).size());
    }
}