package com.review;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Solution_98Test {

    @Test
    public void testSmallestIndex() {
        Solution_98 solution98 = new Solution_98();
        solution98.smallestIndex(new int[]{1, 3, 2});
    }

    @Test
    public void testMinSwaps() {
        Solution_98 solution98 = new Solution_98();
        System.out.println(solution98.minSwaps(new int[]{268835996,65052660,415128775}));
    }

    @Test
    public void testMinMoves() {
        Solution_98 solution98 = new Solution_98();
        System.out.println(solution98.minMoves(new String[]{"A..",".A.","..."}));
       System.out.println(solution98.minMoves(new String[]{"..BC.C.","...F..G","#.F..FA","D.ABEAB","E....BE","ADDF...","E#..BA.","#FD#.#A"}));
    }
}