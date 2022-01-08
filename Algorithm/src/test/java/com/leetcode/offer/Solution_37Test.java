package com.leetcode.offer;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_37Test {

    @Test
    public void testSerialize() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        Solution_37 solution_37 = new Solution_37();
        System.out.println(solution_37.serialize(t1));
        solution_37.deserialize("1|2|3|N|N|4|5|N|N|N|N");
    }
}