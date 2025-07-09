package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_209Test {

    @Test
    public void testMinSubArrayLen() {
        Solution_209 solution209 = new Solution_209();
        System.out.println(solution209.minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
}