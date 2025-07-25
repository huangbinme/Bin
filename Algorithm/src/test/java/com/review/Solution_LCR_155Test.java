package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_LCR_155Test {

    @Test
    public void testTreeToDoublyList() {
        TreeNode t = new TreeNode(1);
        Solution_LCR_155 solutionLcr155 = new Solution_LCR_155();
        solutionLcr155.treeToDoublyList(t);
    }
}