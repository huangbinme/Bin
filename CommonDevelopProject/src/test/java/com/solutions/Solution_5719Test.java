package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_5719Test {

    @Test
    public void testGetMaximumXor() {
        Solution_5719 solution_5719 = new Solution_5719();
        solution_5719.getMaximumXor(new int[]{0,1,2,2,5,7},3);
    }
}