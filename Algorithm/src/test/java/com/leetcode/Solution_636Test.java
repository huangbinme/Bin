package com.leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution_636Test {

    @Test
    public void testExclusiveTime() {
        Solution_636 solution_636 = new Solution_636();
        System.out.println(Arrays.toString(solution_636.exclusiveTime(1, Arrays.asList("0:start:0","0:end:0"))));
    }
}