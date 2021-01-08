package com.solutions;

public class Solution_72 {
    public int minDistance(String word1, String word2) {
        if(word1.length()==0||word2.length()==0){
            return Math.max(word1.length(),word2.length());
        }

        int a = word1.length();
        int b = word2.length();
        int[][] dp = new int[a][b];

        int index = word1.indexOf(word2.charAt(0));
        for (int i = 0; i < a; i++) {
            dp[i][0] = i+1;
        }
        if(index>=0){
            for (int i = index; i < a; i++) {
                dp[i][0] = dp[i][0]-1;
            }
        }

        int index2 = word2.indexOf(word2.charAt(0));
        for (int i = 0; i < b; i++) {
            dp[0][i] = i+1;
        }
        if(index2>=0){
            for (int i = index2; i < b; i++) {
                dp[0][i] = dp[0][i]-1;
            }
        }

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(i==0||j==0){
                    continue;
                }
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j])+1;
                }
            }
        }
        return dp[a-1][b-1];
    }
}
