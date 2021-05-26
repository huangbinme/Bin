package com.solutions;

import org.testng.annotations.Test;

public class Solution_Offer_03Test {

    @Test
    public void testFindRepeatNumber() {
        Solution_Offer_03 solution_offer_03 = new Solution_Offer_03();
        System.out.println(solution_offer_03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}