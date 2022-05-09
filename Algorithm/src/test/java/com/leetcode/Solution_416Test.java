package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_416Test {

    @Test
    public void testCanPartition() {
        Solution_416 solution_416 = new Solution_416();
        System.out.println(solution_416.canPartition(new int[]{14,9,8,4,3,2}));
    }
}