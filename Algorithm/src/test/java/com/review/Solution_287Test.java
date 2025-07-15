package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_287Test {

    @Test
    public void testFindDuplicate() {
        Solution_287 solution287 = new Solution_287();
        System.out.println(solution287.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(solution287.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(solution287.findDuplicate(new int[]{3,3,3,3,3}));
    }
}