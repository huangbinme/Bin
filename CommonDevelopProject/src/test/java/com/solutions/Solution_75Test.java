package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_75Test {

    @Test
    public void testSortColors() {
        Solution_75 solution_75 = new Solution_75();
        solution_75.sortColors(new int[]{2,0,2,1,1,0});
    }
}