package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
