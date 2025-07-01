package com;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void testSolution() {
        System.out.println(Solution.findVulnerabilityFactor(Arrays.asList(5, 10, 20, 10, 15, 5), 2));
        System.out.println(Solution.findVulnerabilityFactor(Arrays.asList(2, 2, 4, 9, 6), 1));
        System.out.println(Solution.findVulnerabilityFactor(Arrays.asList(4,2,4), 1));
    }
}