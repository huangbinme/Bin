package com.solutions;

import java.util.ArrayList;
import java.util.List;

public class Solution_1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>(A.length);
        int[] dp = new int[A.length];
        dp[0] = A[0] == 0 ? 0 : 1;
        result.add(A[0] == 0);
        for (int i = 1; i < dp.length; i++) {
            if (A[i] == 0) {
                dp[i] = (dp[i - 1] * 2) % 5;
            } else {
                dp[i] = (dp[i - 1] * 2 + 1) % 5;
            }
            result.add(dp[i] % 5 == 0);
        }
        return result;
    }
}
