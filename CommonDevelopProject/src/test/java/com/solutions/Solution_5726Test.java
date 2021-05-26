package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_5726Test {

    @Test
    public void testArraySign() {
        Solution_5726 s = new Solution_5726();
        System.out.println(s.arraySign(new int[]{-1,1,-1,1,-1}));
    }
}