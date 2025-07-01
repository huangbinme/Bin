package com.review;

import com.leetcode.Solution_697;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_97Test {

    @Test
    public void testIsInterleave() {
        Solution_97 solution97 = new Solution_97();
        System.out.println(solution97.isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}