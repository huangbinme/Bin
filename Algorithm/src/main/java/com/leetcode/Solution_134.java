package com.leetcode;

public class Solution_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //1,2,3,4,5
        //3,4,5,1,2
        //-2,-2,-2,+3,+3
        int[] gasChange = new int[gas.length];
        int minGas = Integer.MAX_VALUE, minGasIndex = -1, gasSum = 0;
        for (int i = 0; i < gasChange.length; i++) {
            gasChange[i] = gas[i] - cost[i];
            gasSum += gasChange[i];
            if (gasSum < minGas) {
                minGas = gasSum;
                minGasIndex = i;
            }
        }
        if (gasSum < 0) return -1;
        return minGasIndex + 1 == gas.length ? 0 : minGasIndex + 1;
    }
}
