package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_442Test {

    @Test
    public void testFindDuplicates() {
        Solution_442 solution442 = new Solution_442();
        System.out.println(solution442.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}