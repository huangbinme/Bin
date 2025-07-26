package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_42Test {

    @Test
    public void testTrap2() {
        Solution_42 s = new Solution_42();
        System.out.println(s.trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}