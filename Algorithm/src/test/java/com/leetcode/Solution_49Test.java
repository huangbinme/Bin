package com.leetcode;

import org.junit.Test;

public class Solution_49Test{

    @Test
    public void groupAnagrams() {
        Solution_49 solution_49 = new Solution_49();
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution_49.groupAnagrams(strings));
    }

    @Test
    public void groupAnagrams2() {
        Solution_49 solution_49 = new Solution_49();
        System.out.println(solution_49.getStr("strings"));
    }
}