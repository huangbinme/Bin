package com;

import com.interview.amazon.Solution_3;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Solution_3Test {

    @Test
    public void testGetMaxServers1() {
        Solution_3 solution3 = new Solution_3();
        System.out.println( Solution_3.getMaxServers1(Arrays.asList(4, 5, 5, 6, 7, 7, 8, 8, 9, 10)));
    }

    @Test
    public void testMaxCredits() {
        List<Integer> inventory = Arrays.asList(10,6,12,8,15,1);
        System.out.println();
    }
}