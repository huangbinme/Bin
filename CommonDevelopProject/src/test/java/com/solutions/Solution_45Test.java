package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_45Test {

    @Test
    public void testJump() {
        Solution_45 solution_45 = new Solution_45();
        System.out.println(solution_45.jump(new int[]{3,2,1}));
    }
}