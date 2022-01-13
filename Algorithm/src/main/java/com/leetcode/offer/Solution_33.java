package com.leetcode.offer;

public class Solution_33 {

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length);
    }

    private boolean dfs(int[] postorder, int start, int end) {
        if (end - start <= 2) return true;
        int base = postorder[end - 1];
        int check = 0, p = start;
        while (postorder[p] < base) {
            p++;
            check++;
        }
        p = end - 2;
        while (p >= 0 && postorder[p] > base) {
            p--;
            check++;
        }
        return check == end - start - 1 && dfs(postorder, start, p + 1) && dfs(postorder, p + 1, end - 1);
    }
}
