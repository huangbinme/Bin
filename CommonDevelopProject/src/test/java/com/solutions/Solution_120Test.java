package com.solutions;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_120Test extends TestCase {

    public void testMinimumTotal() {

        Solution_120 solution_120 = new Solution_120();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = Arrays.asList(2);
        List<Integer> list1 = Arrays.asList(3,4);
        List<Integer> list2 = Arrays.asList(6,5,7);
        List<Integer> list3 = Arrays.asList(4,1,8,3);
        triangle.add(list);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);

        System.out.println(solution_120.minimumTotal(triangle));
    }
}