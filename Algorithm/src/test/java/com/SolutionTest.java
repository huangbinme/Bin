package com;

import org.testng.annotations.Test;

public class SolutionTest {

    @Test
    public void testSolution() {

    }

    @Test
    public void testMinLength() {
        int[] ints = new int[]{0, 1, 0, 0, 1, 1, 0, 0};
        int[] ints2 = new int[]{3, 5, 10, 12, 13, 23, 30, 38};
        System.out.println(Solution.minLength(ints, ints2));
    }
}