package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_81Test {

    @Test
    public void testSearch() {
        Solution_81 solution81 = new Solution_81();
        System.out.println(solution81.search(new int[]{2,5,6,0,0,1,2},3));
    }
}