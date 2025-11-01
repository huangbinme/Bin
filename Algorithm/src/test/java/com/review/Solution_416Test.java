package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_416Test {

    @Test
    public void testCanPartition() {
        Solution_416 solution416 = new Solution_416();
        System.out.println(solution416.canPartition(new int[]{1,5,11,5}));
    }
}