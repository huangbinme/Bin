package com.interview.traveloka;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SolutionTest {

    @Test
    public void testPilesOfBoxes() {
        Solution solution = new Solution();
        //3 2 1
        System.out.println(Solution.pilesOfBoxes(Arrays.asList(
                5,2,1)));//6
    }

    @Test
    public void testCompressWord() {
        System.out.println(Solution.compressWord("baac", 2));
    }
}