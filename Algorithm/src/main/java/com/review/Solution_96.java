package com.review;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;

public class Solution_96 {

    Map<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        return dfs(1, n);
    }

    private int dfs(int min, int max) {
        if (min >= max) return 1;
        int fre = map.getOrDefault(max - min, -1);
        if (fre != -1) return fre;
        int ans = 0;
        for (int i = min; i <= max; i++) {
            int l = dfs(min, i - 1);
            int r = dfs(i + 1, max);
            ans += l * r;
        }
        map.put(max - min, ans);
        return ans;
    }

    public int solution(int[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    boolean[][] visit = new boolean[board.length][board[0].length];
                    int dfs = dfs(board, visit, i, j, 0, 4);
                    ans = Math.max(ans, dfs);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] board, boolean[][] visit, int i, int j, int num, int step) {
        if (step == 0 || visit[i][j]) return num;
        visit[i][j] = true;
        int newNum = num == 0 ? board[i][j] : num * 10 + board[i][j];
        int ans = newNum;
        if (inbound(board, i - 1, j)) ans = Math.max(ans, dfs(board, visit, i - 1, j, newNum, step - 1));
        if (inbound(board, i + 1, j)) ans = Math.max(ans, dfs(board, visit, i + 1, j, newNum, step - 1));
        if (inbound(board, i, j - 1)) ans = Math.max(ans, dfs(board, visit, i, j - 1, newNum, step - 1));
        if (inbound(board, i, j + 1)) ans = Math.max(ans, dfs(board, visit, i, j + 1, newNum, step - 1));
        visit[i][j] = false;
        return ans;
    }

    private boolean inbound(int[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    public static void main(String[] args) throws Exception {
        String key = "secret-key";
        String message = "hello world";

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);

        byte[] hash = sha256_HMAC.doFinal(message.getBytes());
        StringBuilder result = new StringBuilder();
        for (byte b : hash) {
            result.append(String.format("%02x", b));
        }
        System.out.println(result.toString());
    }

}

