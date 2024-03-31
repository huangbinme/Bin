package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_215Test {

    @Test
    public void testFindKthLargest() {
        Solution_215 solution215 = new Solution_215();
        System.out.println(solution215.findKthLargest(new int[]{2,1}, 2));
    }
}