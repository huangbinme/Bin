package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_128Test {

    @Test
    public void testLongestConsecutive() {
        Solution_128 solution128 = new Solution_128();
        System.out.println(solution128.longestConsecutive(new int[]{-1,1,0}));
    }
}