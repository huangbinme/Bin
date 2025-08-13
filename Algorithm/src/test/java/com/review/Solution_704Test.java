package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_704Test {

    @Test
    public void testSearch() {
        Solution_704 solution704 = new Solution_704();
        System.out.println(solution704.search(new int[]{5}, 5));
    }
}