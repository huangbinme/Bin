package com.interview.scb;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class SolutionTest {

    @Test
    public void testMinNum() {
        System.out.println(Solution.minNum(650, Arrays.asList(10,82,112,134,178,206,229,238,278,293,335)));
    }
}