package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution_412 {
    public List<String> fizzBuzz(int n) {
        String str1 = "FizzBuzz", str2 = "Fizz", str3 = "Buzz";
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add(str1);
            } else if (i % 3 == 0) {
                ans.add(str2);
            } else if (i % 5 == 0) {
                ans.add(str3);
            } else {
                ans.add(String.valueOf(i));
            }
        }
        return ans;
    }
}
