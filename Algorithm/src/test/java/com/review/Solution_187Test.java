package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_187Test {

    @Test
    public void testFindRepeatedDnaSequences() {
        Solution_187 solution187 = new Solution_187();
        System.out.println(solution187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}