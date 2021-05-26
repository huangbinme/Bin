package com.solutions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_5736Test {

    @Test
    public void testGetOrder() {
        Solution_5736 solution_5736 = new Solution_5736();
        //[[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]
        int[][] ints = new int[14][2];
        ints[0][0] = 19;
        ints[0][1] = 13;
        ints[1][0] = 16;
        ints[1][1] = 9;
        solution_5736.getOrder(ints);
    }
}