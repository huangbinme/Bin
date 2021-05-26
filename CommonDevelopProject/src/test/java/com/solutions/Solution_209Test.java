package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_209Test {

    @Test
    public void testMinSubArrayLen() {
        Solution_209 solution_209 = new Solution_209();
        System.out.println(solution_209.minSubArrayLen(7,new int[]{2}));
    }
}