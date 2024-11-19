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
            for (int j = dp.length - 1; j > 0; j--) {//后遍历背包最大容量
                //为什么0-1背包在一维数组中必须倒序遍历背包的最大容量？
                //因为状态转移公式为：dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                //因为一个物品只能被选一次，dp[j - weight[i]]只能使用上一次迭代的结果值
                //dp[j - weight[i]]必定在dp[j]的右边，所以采用倒序遍历
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
                //为什么完全背包在一维数组中必须正序遍历背包的最大容量？
                //因为状态转移公式为：dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                //因为一个物品能被选多次，dp[j - weight[i]]必须使用本次迭代更新过的结果
                //dp[j - weight[i]]必定在dp[j]的右边，所以采用正序遍历
                if (weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[dp.length - 1];
    }
}
