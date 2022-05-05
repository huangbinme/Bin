package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_253Test {

    @Test
    public void testMinMeetingRooms() {
        Solution_253 solution_253 = new Solution_253();
        int[][] ints = new int[3][2];
        ints[0] = new int[]{0, 30};
        ints[1] = new int[]{5, 10};
        ints[2] = new int[]{15, 20};
        System.out.println(solution_253.minMeetingRooms(ints));
    }
}