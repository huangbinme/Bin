package com.algorithm.dp;

public class BagProblem {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        BagProblem bagProblem = new BagProblem();
        System.out.println(bagProblem.zeroOneBag(weight, value, bagSize));
    }

    public int zeroOneBag(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {//先遍历物品
            for (int j = dp.length - 1; j > 0; j--) {
                //遍历背包的最大容量
                //0-1背包在一维数组中必须倒序遍历背包的最大容量
                if (weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    public int completedBag(int[] weight, int[] value, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {//先遍历物品
            for (int j = 1; j < dp.length; j++) {
                //遍历背包的最大容量
                //0-1背包在一维数组中必须正序遍历背包的最大容量
                if (weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
