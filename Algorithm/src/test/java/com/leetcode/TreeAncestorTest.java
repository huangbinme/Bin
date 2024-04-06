package com.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class TreeAncestorTest {

    @Test
    public void testGetKthAncestor() {
        TreeAncestor treeAncestor = new TreeAncestor(6, new int[]{-1,2,3,4,5,0});
        System.out.println(treeAncestor.getKthAncestor(1,4));
    }
}